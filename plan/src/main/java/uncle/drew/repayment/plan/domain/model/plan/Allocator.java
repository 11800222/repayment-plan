package uncle.drew.repayment.plan.domain.model.plan;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Allocator {

    private final AllocatePolicy allocatePolicy;

    private final AllocateLimits allocateLimits;

    public Allocator(AllocatePolicy allocatePolicy, AllocateLimits allocateLimits) {
        this.allocatePolicy = allocatePolicy;
        this.allocateLimits = allocateLimits;
    }

    public int calMinTotalCycle(Long totalAmount) {
        return 0;
    }

    public int calMaxTotalCycle(Long totalAmount) {
        return 0;
    }

    public void fill(ArrayList<RepayPlanCycle> cycles, Long totalAmount) {
        int avgCycleAmount = (int) (totalAmount / cycles.size());
        for (int currentCycleIndex = 0; currentCycleIndex < cycles.size(); currentCycleIndex++) {
            AllocatorSingleCycle allocatorSingleCycle = new AllocatorSingleCycle(allocateLimits.getMinSingleBillAmount()
                    , allocateLimits.getMaxSingleBillAmount(), allocateLimits.getRate(), allocatePolicy.getConsumeSplitScales());
            if (currentCycleIndex < cycles.size() / 2) {
                int maxSingleCycleAmount = allocatorSingleCycle.calMaxSingleCycleAmount();
                int minSingleCycleAmount = allocatorSingleCycle.calMinSingleCycleAmount();
                int amount = randomAmount(avgCycleAmount, maxSingleCycleAmount, minSingleCycleAmount);
                allocatorSingleCycle.fill(cycles.get(currentCycleIndex), amount);
            } else {
                int amount = avgCycleAmount + (avgCycleAmount - (cycles.get(currentCycleIndex - currentCycleIndex / 2).getRepayAmount()));
                allocatorSingleCycle.fill(cycles.get(currentCycleIndex), amount);
            }
        }
    }


    public int randomAmount(int base, int up, int down) {
        BigDecimal dw = allocatePolicy.getRepayBillFloatUp();
        BigDecimal dwd = allocatePolicy.getRepayBillFloatDown();
        return (up + down) / 2;
    }

}
