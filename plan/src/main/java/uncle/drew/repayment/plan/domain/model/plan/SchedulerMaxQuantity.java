package uncle.drew.repayment.plan.domain.model.plan;

import java.util.ArrayList;
import java.util.Date;


public class SchedulerMaxQuantity extends Scheduler {


    public SchedulerMaxQuantity(SchedulePolicy schedulePolicy, ScheduleLimits scheduleLimits) {
        super(schedulePolicy, scheduleLimits);
    }

    @Override
    ArrayList<RepayPlanCycle> scheduleForFirstDay(TimeSpan timeSpan, Integer leftTotalCycleAmount) {
        return null;
    }

    @Override
    ArrayList<RepayPlanCycle> scheduleForSingleDay(TimeSpan timeSpan, Integer leftTotalCycleAmount) {
        return null;
    }


}
