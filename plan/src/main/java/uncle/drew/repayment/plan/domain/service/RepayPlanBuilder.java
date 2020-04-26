package uncle.drew.repayment.plan.domain.service;

import sun.dc.pr.PRError;
import uncle.drew.repayment.plan.domain.model.plan.*;

import java.util.ArrayList;

public class RepayPlanBuilder {

    private final SchedulePolicy schedulePolicy;
    private final ScheduleLimits scheduleLimits;
    private final AllocatePolicy allocatePolicy;
    private final AllocateLimits allocateLimits;

    public RepayPlanBuilder(SchedulePolicy schedulePolicy, ScheduleLimits scheduleLimits, AllocatePolicy allocatePolicy, AllocateLimits allocateLimits) {
        this.schedulePolicy = schedulePolicy;
        this.scheduleLimits = scheduleLimits;
        this.allocatePolicy = allocatePolicy;
        this.allocateLimits = allocateLimits;
    }

    public RepayPlan createReplayPlan(Long userId,
                                      Long cardId,
                                      Long totalAmount,
                                      String channelCode,
                                      int totalCycle,
                                      TimeSpan timeSpan) {
        //判断是否有解
        Scheduler scheduler = new SchedulerMaxQuantity(schedulePolicy, scheduleLimits);
        int maxCycleInScheduler = scheduler.generateSchedule(timeSpan, null).size();
        int minCycleInScheduler = Math.toIntExact(timeSpan.daysApart() - 1);

        Allocator allocator = new Allocator(allocatePolicy, allocateLimits);
        int maxCycleInAllocator = allocator.calMaxTotalCycle(totalAmount);
        int minCycleInAllocator = allocator.calMinTotalCycle(totalAmount);

        if (!(Math.max(minCycleInAllocator, minCycleInScheduler) <= totalCycle && totalCycle <= Math.min(maxCycleInAllocator, maxCycleInScheduler))) {
            throw new IllegalArgumentException("指定的笔数不存在解");
        }
        //安排时间
        ArrayList<RepayPlanCycle> planCycles = new SchedulerFixedQuantity(schedulePolicy, scheduleLimits)
                .generateSchedule(timeSpan, totalCycle);

        //分配金额
        allocator.fill(planCycles, totalAmount);

        //填充账单信息
        planCycles.forEach(repayPlanCycle -> {
            repayPlanCycle.getConsumes().forEach(billConsume -> {
                billConsume.setChannelCode(channelCode);
                billConsume.setRepayCardId(cardId);
                billConsume.setUserId(userId);
            });
            repayPlanCycle.getBillRepay().setChannelCode(channelCode);
            repayPlanCycle.getBillRepay().setRepayCardId(cardId);
            repayPlanCycle.getBillRepay().setUserId(userId);
        });

        return new RepayPlan(planCycles, RepayPlanState.init);
    }
}
