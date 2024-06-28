package pl.PJATK.currencies.Inquiry;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.PJATK.currencies.Rate.ExchangeRates;

@RestController
@Tag(name = "Inquiry Controller", description = "Operations based on user inquiries")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/{currency}")
    @Operation(summary = "Get mean of currency from the last X callendar days")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculated mean of currency"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Currency or dates not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Double> getMeanOfCurrency(@PathVariable String currency, @RequestParam(required = false) Integer days) {
        int daysValid = (days != null && days > 0) ? days : 1;
        return ResponseEntity.ok(inquiryService.getMeanOfCurrency(currency, daysValid));
    }

    @GetMapping("/list/{currency}")
    @Operation(summary = "Get all currencies value form last X callendar days")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succesfully obtained list of currency values"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Currency or dates not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<ExchangeRates> getCurrency(@PathVariable String currency, @RequestParam(required = false) Integer days) {
        int daysValid = (days != null && days > 0) ? days : 1;
        return ResponseEntity.ok(inquiryService.getCurrency(currency, daysValid));
    }
}
