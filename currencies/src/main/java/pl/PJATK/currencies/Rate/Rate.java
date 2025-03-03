package pl.PJATK.currencies.Rate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(hidden = true)
public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;

    public Rate() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }
}
