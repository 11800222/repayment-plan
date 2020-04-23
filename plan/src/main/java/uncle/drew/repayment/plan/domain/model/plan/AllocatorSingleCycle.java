package uncle.drew.repayment.plan.domain.model.plan;


import java.math.BigDecimal;
import java.util.List;


class AllocatorSingleCycle {

    private final Integer minBillAmount;

    private final Integer maxBillAmount;

    private final BigDecimal rate;

    private final List<String> consumeSplitScales;

    public AllocatorSingleCycle(Integer minBillAmount, Integer maxBillAmount, BigDecimal rate, List<String> consumeSplitScales) {
        this.minBillAmount = minBillAmount;
        this.maxBillAmount = maxBillAmount;
        this.rate = rate;
        this.consumeSplitScales = consumeSplitScales;
    }

    public void fill(RepayPlanCycle cycle, int totalAmount) {

    }

    public int calMaxSingleCycleAmount() {
        //根据最大消费金额，计算允许分配最大还款金额
        return 0;
    }

    public int calMinSingleCycleAmount() {
        //根据最小消费金额，计算允许分配最小还款金额
        return 0;
    }
}

