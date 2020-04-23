package uncle.drew.repayment.plan.domain.model.plan;

import java.math.BigDecimal;

public class AllocateLimits {

    private final Integer minSingleBillAmount;

    private final Integer maxSingleBillAmount;

    private final BigDecimal rate;

    public AllocateLimits(Integer minSingleBillAmount, Integer maxSingleBillAmount, BigDecimal rate) {
        this.minSingleBillAmount = minSingleBillAmount;
        this.maxSingleBillAmount = maxSingleBillAmount;
        this.rate = rate;
    }

    public Integer getMinSingleBillAmount() {
        return minSingleBillAmount;
    }

    public Integer getMaxSingleBillAmount() {
        return maxSingleBillAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
