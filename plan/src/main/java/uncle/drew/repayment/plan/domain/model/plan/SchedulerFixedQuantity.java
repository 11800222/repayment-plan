package uncle.drew.repayment.plan.domain.model.plan;

import java.util.ArrayList;
import java.util.Date;


public class SchedulerFixedQuantity extends Scheduler {

    public SchedulerFixedQuantity(SchedulePolicy schedulePolicy, ScheduleLimits scheduleLimits) {
        super(schedulePolicy, scheduleLimits);
    }

    @Override
    ArrayList<RepayPlanCycle> scheduleForFirstDay(Date begin, Date end, Integer totalCycle) {
        return new SchedulerSingleDay(begin, end).schedule(schedulePolicy.getHourIntervals(), schedulePolicy.getCycle());
    }

    @Override
    ArrayList<RepayPlanCycle> scheduleForSingleDay(Date begin, Date end, Integer totalCycle) {
        return new SchedulerSingleDay(begin, end).schedule(schedulePolicy.getHourIntervals(), schedulePolicy.getCycle());
    }


}
