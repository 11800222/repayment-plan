package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import org.apache.commons.lang3.time.DateUtils;
import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.util.ArrayList;
import java.util.Date;


public abstract class AbstractBillTimeScheduler {
    protected final TimeRange timeRange;

    protected final Date dayAllowBeginTime;

    protected final Date dayAllowEndTime;

    protected final Integer hourIntervals;

    protected final Integer cycle;


    public AbstractBillTimeScheduler(Date beginTime, Date endTime, Date dayAllowBeginTime, Date dayAllowEndTime, Integer hourIntervals, Integer cycle) {
        this.hourIntervals = hourIntervals;
        this.cycle = cycle;
        timeRange = new TimeRange(beginTime, endTime);
        this.dayAllowBeginTime = dayAllowBeginTime;
        this.dayAllowEndTime = dayAllowEndTime;
    }

    /**
     * schedule模板方法
     */
    public ArrayList<RepayCycle> generateSchedule(int totalCycleAmount) {
        ArrayList<RepayCycle> repayCycles = new ArrayList<RepayCycle>();
        Date currentDay = timeRange.getBegin();
        while (!currentDay.after(timeRange.getEnd())) {
            if (DateUtils.isSameDay(currentDay, new Date())) {
                //当天计划处理
                Date currentDayBeginTime = timeRange.getBegin().after(dayAllowBeginTime) ? timeRange.getBegin() : dayAllowBeginTime;
                if (timeRange.getBegin().before(dayAllowEndTime)) {
                    repayCycles.addAll(scheduleForFirstDay(currentDayBeginTime, dayAllowEndTime, totalCycleAmount));
                }
            } else {
                repayCycles.addAll(scheduleForSingleDay(dayAllowBeginTime, dayAllowEndTime, totalCycleAmount));
            }
            DateUtils.addDays(currentDay, 1);
            totalCycleAmount = totalCycleAmount - repayCycles.size();
        }
        return repayCycles;
    }

    abstract ArrayList<RepayCycle> scheduleForFirstDay(Date begin, Date end, Integer leftTotalCycleAmount);


    abstract ArrayList<RepayCycle> scheduleForSingleDay(Date begin, Date end, Integer leftTotalCycleAmount);
}

