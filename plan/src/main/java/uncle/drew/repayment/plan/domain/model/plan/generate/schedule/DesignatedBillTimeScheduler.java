package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.util.ArrayList;
import java.util.Date;


public class DesignatedBillTimeScheduler extends AbstractBillTimeScheduler {


    public DesignatedBillTimeScheduler(Date beginTime, Date endTime, Date dayAllowBeginTime, Date dayAllowEndTime, Integer hourIntervals, Integer cycle) {
        super(beginTime, endTime, dayAllowBeginTime, dayAllowEndTime, hourIntervals, cycle);
    }

    @Override
    ArrayList<RepayCycle> scheduleForFirstDay(Date begin, Date end, Integer totalCycle) {
        //todo:对于给定
        return null;
    }

    @Override
    ArrayList<RepayCycle> scheduleForSingleDay(Date begin, Date end, Integer totalCycle) {
        return null;
    }

    calFirst
}
