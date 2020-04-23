package uncle.drew.repayment.plan.domain.model.plan;

import java.util.ArrayList;
import java.util.Date;

class SchedulerSingleDay {
    private final TimeSpan timeSpan;

    SchedulerSingleDay(Date begin, Date end) {
        timeSpan = new TimeSpan(begin, end);
        if (!timeSpan.isSameDay()) {
            throw new IllegalArgumentException("传入的开始、结束时间不在同一天");
        }
    }

    ArrayList<RepayPlanCycle> schedule(int hourIntervals, int cycle) {

        //todo: ArrayList<Date> 转 ArrayList<Cycle>
        return new ArrayList<RepayPlanCycle>();
    }

    ArrayList<RepayPlanCycle> schedule(int hourIntervals, int cycle, int totalCycle) {
        //todo: ArrayList<Date> 转 ArrayList<Cycle>
        return new ArrayList<RepayPlanCycle>();
    }
}

