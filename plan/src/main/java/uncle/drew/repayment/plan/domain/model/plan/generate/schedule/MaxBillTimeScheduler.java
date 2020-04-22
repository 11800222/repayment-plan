package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.util.ArrayList;
import java.util.Date;


public class MaxBillTimeScheduler extends AbstractBillTimeScheduler {

    public MaxBillTimeScheduler(ScheduleLimits scheduleLimits, ScheduleStrategy scheduleStrategy) {
        super(scheduleLimits, scheduleStrategy);
    }

    @Override
    ArrayList<RepayCycle> scheduleForFirstDay(Date begin, Date end, Integer totalCycle) {
        return new SingleDayScheduler(begin, end).schedule(scheduleStrategy.getHourIntervals(), scheduleStrategy.getCycle());
    }

    @Override
    ArrayList<RepayCycle> scheduleForSingleDay(Date begin, Date end, Integer totalCycle) {
        return new SingleDayScheduler(begin, end).schedule(scheduleStrategy.getHourIntervals(), scheduleStrategy.getCycle());
    }


}
