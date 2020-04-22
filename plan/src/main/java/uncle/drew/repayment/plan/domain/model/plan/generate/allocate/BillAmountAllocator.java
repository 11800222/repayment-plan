package uncle.drew.repayment.plan.domain.model.plan.generate.allocate;

import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BillAmountAllocator {

    private final AllocateStrategy allocateStrategy;

    private final AmountLimits amountLimits;

    public BillAmountAllocator(AllocateStrategy allocateStrategy, AmountLimits amountLimits) {
        this.allocateStrategy = allocateStrategy;
        this.amountLimits = amountLimits;
    }

    public int calMinTotalCycle(int totalAmount) {
        return 0;
    }

    public int calMaxTotalCycle(int totalAmount) {
        return 0;
    }

    public void fill(ArrayList<RepayCycle> cycles, int totalAmount) {
        int avgCycleAmount = totalAmount / cycles.size();
        for (int currentCycleIndex = 0; currentCycleIndex < cycles.size(); currentCycleIndex++) {
            SingleCycleAmountAllocator singleCycleAmountAllocator = new SingleCycleAmountAllocator(amountLimits.getMinSingleBillAmount()
                    , amountLimits.getMaxSingleBillAmount(), allocateStrategy.getConsumeSplitScales());
            if (currentCycleIndex < cycles.size() / 2) {
                int maxSingleCycleAmount = singleCycleAmountAllocator.calMaxSingleCycleAmount();
                int minSingleCycleAmount = singleCycleAmountAllocator.calMinSingleCycleAmount();
                int amount = randomAmount(avgCycleAmount, maxSingleCycleAmount, minSingleCycleAmount);
                singleCycleAmountAllocator.fill(cycles.get(currentCycleIndex), amount);
            } else {
                int amount = avgCycleAmount + (avgCycleAmount - (cycles.get(currentCycleIndex - currentCycleIndex / 2).getRepayAmount()));
                singleCycleAmountAllocator.fill(cycles.get(currentCycleIndex), amount);
            }
        }
    }


    public int randomAmount(int base, int up, int down) {
        BigDecimal dw = allocateStrategy.getRepayBillFloatUp();
        BigDecimal dwd = allocateStrategy.getRepayBillFloatDown();
        return (up + down) / 2;
    }

}
