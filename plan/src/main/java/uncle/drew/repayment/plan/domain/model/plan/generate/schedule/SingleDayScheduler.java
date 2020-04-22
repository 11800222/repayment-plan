package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.util.ArrayList;
import java.util.Date;

class SingleDayScheduler {
    private final TimeRange timeRange;

    SingleDayScheduler(Date begin, Date end) {
        timeRange = new TimeRange(begin, end);
        if (!timeRange.isSameDay()) {
            throw new IllegalArgumentException("传入的开始、结束时间不在同一天");
        }
    }

    ArrayList<RepayCycle> schedule(int hourIntervals, int cycle) {

        //todo: ArrayList<Date> 转 ArrayList<Cycle>
        return new ArrayList<RepayCycle>();
    }

    ArrayList<RepayCycle> schedule(int hourIntervals, int cycle,int totalCycle) {
        //todo: ArrayList<Date> 转 ArrayList<Cycle>
        return new ArrayList<RepayCycle>();
    }
}

