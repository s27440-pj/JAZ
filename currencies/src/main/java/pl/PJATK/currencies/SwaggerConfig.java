package pl.PJATK.currencies;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.PJATK.currencies.Inquiry.Inquiry;

import java.time.LocalDateTime;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSchemas("Inquiry", new Schema<Inquiry>()
                                .example(new Inquiry("USD", 7, LocalDateTime.now(), 3.5))
                                .title("Inquiry")
                                .description("Information about user's inquiries")
                                .addProperties("id", new Schema<Long>().type("integer").format("int64").description("Unique id of inquiry").example(2))
                                .addProperties("currency", new Schema<String>().type("string").description("Currency name").example("USD"))
                                .addProperties("days", new Schema<Integer>().type("integer").description("Number of calendar days that user is interested into").example(7))
                                .addProperties("date", new Schema<String>().type("string").format("date-time").description("Date of inquiry").example("2024-03-25T14:55:00"))
                                .addProperties("meanCourse", new Schema<Double>().type("number").description("Calculated mean of currency from X calendar days").example(3.5))
                        ))
                .info(new Info().title("Inquiry API").version("1.0").description("API for managing currency inquiries"));
    }

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
        return openApi -> {
            openApi.schema("Inquiry", new Schema<Inquiry>()
                    .title("Inquiry")
                    .description("Information about user's inquiries")
                    .addProperties("id", new Schema<Long>().type("integer").format("int64").description("Unique id of inquiry").example(2))
                    .addProperties("currency", new Schema<String>().type("string").description("Currency name").example("USD"))
                    .addProperties("days", new Schema<Integer>().type("integer").description("Number of calendar days that user is interested into").example(7))
                    .addProperties("date", new Schema<String>().type("string").format("date-time").description("Date of inquiry").example("2024-03-25T14:55:00"))
                    .addProperties("meanCourse", new Schema<Double>().type("number").description("Calculated mean of currency from X calendar days").example(3.5))
            );
            openApi.getComponents().getSchemas().remove("Rate");
            openApi.getComponents().getSchemas().remove("ExchangeRates");
        };
    }
}
