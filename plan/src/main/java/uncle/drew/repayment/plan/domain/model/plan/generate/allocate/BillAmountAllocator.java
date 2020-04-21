package uncle.drew.repayment.plan.domain.model.plan.generate.allocate;

import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BillAmountAllocator {

    private final Integer minSingleBillAmount;

    private final Integer maxSingleBillAmount;

    private final BigDecimal repayBillFloatUp;

    private final BigDecimal repayBillFloatDown;

    private final List<String> consumeSplitScales;

    protected final Integer cycle;

    public BillAmountAllocator(Integer minSingleBillAmount, Integer maxSingleBillAmount, BigDecimal repayBillFloatUp, BigDecimal repayBillFloatDown, List<String> consumeSplitScales, Integer cycle) {
        this.minSingleBillAmount = minSingleBillAmount;
        this.maxSingleBillAmount = maxSingleBillAmount;
        this.repayBillFloatUp = repayBillFloatUp;
        this.repayBillFloatDown = repayBillFloatDown;
        this.consumeSplitScales = consumeSplitScales;
        this.cycle = cycle;
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
            SingleCycleAllocator singleCycleAllocator = new SingleCycleAllocator(minSingleBillAmount, maxSingleBillAmount, consumeSplitScales);
            if (currentCycleIndex < cycles.size() / 2) {
                int maxSingleCycleAmount = singleCycleAllocator.calMaxSingleCycleAmount();
                int minSingleCycleAmount = singleCycleAllocator.calMinSingleCycleAmount();
                int amount = randomAmount(avgCycleAmount, maxSingleCycleAmount, minSingleCycleAmount);
                singleCycleAllocator.fill(cycles.get(currentCycleIndex), amount);
            } else {
                int amount = avgCycleAmount + (avgCycleAmount - (cycles.get(currentCycleIndex - currentCycleIndex / 2).getRepayAmount()));
                singleCycleAllocator.fill(cycles.get(currentCycleIndex), amount);
            }
        }
    }


    public int randomAmount(int base, int up, int down) {
        BigDecimal dw = repayBillFloatUp;
        BigDecimal dwd = repayBillFloatDown;
        return (up + down) / 2;
    }

}
