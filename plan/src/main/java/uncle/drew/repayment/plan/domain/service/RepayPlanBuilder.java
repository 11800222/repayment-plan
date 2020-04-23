package uncle.drew.repayment.plan.domain.service;

import uncle.drew.repayment.plan.domain.model.plan.*;

import java.util.ArrayList;
import java.util.Date;

public class RepayPlanBuilder {

    public RepayPlan createReplayPlan(Long userId,
                                      Long cardId,
                                      Long totalAmount,
                                      int totalCycleAmount,
                                      TimeSpan timeSpan,
                                      SchedulePolicy schedulePolicy,
                                      ScheduleLimits scheduleLimits,
                                      AllocatePolicy allocatePolicy,
                                      AllocateLimits allocateLimits) {
        Scheduler scheduler = new SchedulerFixedQuantity(schedulePolicy, scheduleLimits);

        ArrayList<RepayPlanCycle> repayPlanCycles = scheduler.generateSchedule(totalCycleAmount, timeSpan.getBegin(), timeSpan.getEnd());


        return null;
    }
}
