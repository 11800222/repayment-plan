package uncle.drew.repayment.plan.domain.model.plan.generate.allocate;


import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.util.List;


class SingleCycleAllocator {

    private final Integer minBillAmount;

    private final Integer maxBillAmount;

    private final List<String> consumeSplitScales;

    public SingleCycleAllocator(Integer minBillAmount, Integer maxBillAmount, List<String> consumeSplitScales) {
        this.minBillAmount = minBillAmount;
        this.maxBillAmount = maxBillAmount;
        this.consumeSplitScales = consumeSplitScales;
    }

    public void fill(RepayCycle cycle, int totalAmount) {

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

