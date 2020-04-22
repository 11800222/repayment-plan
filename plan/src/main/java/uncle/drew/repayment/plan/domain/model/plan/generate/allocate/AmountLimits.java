package uncle.drew.repayment.plan.domain.model.plan.generate.allocate;


public class AmountLimits {

    private final Integer minSingleBillAmount;

    private final Integer maxSingleBillAmount;

    public AmountLimits(Integer minSingleBillAmount, Integer maxSingleBillAmount) {
        this.minSingleBillAmount = minSingleBillAmount;
        this.maxSingleBillAmount = maxSingleBillAmount;
    }

    public Integer getMinSingleBillAmount() {
        return minSingleBillAmount;
    }

    public Integer getMaxSingleBillAmount() {
        return maxSingleBillAmount;
    }
}
