package uncle.drew.repayment.plan.domain.model.plan;

import java.util.ArrayList;
import java.util.Date;


public class SchedulerFixedQuantity extends Scheduler {

    public SchedulerFixedQuantity(SchedulePolicy schedulePolicy, ScheduleLimits scheduleLimits) {
        super(schedulePolicy, scheduleLimits);
    }

    @Override
    ArrayList<RepayPlanCycle> scheduleForFirstDay(TimeSpan timeSpan, Integer totalCycle) {
        Long avgCycle = totalCycle / timeSpan.daysApart();
        Long expectedCycle = totalCycle % timeSpan.daysApart() == 0 ? totalCycle / timeSpan.daysApart() : totalCycle % timeSpan.daysApart();
        return null;
    }

    @Override
    ArrayList<RepayPlanCycle> scheduleForSingleDay(TimeSpan timeSpan, Integer leftTotalCycleAmount) {
        return null;
    }



}
