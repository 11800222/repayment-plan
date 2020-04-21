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

    /**
     *  这些参数能作为AbstractBillTimeScheduler的字段，是因为它们能体现出AbstractBillTimeScheduler的自身属性
     */
    public AbstractBillTimeScheduler(Date beginTime, Date endTime, Date dayAllowBeginTime, Date dayAllowEndTime, Integer hourIntervals, Integer cycle) {
        this.hourIntervals = hourIntervals;
        this.cycle = cycle;
        timeRange = new TimeRange(beginTime, endTime);
        this.dayAllowBeginTime = dayAllowBeginTime;
        this.dayAllowEndTime = dayAllowEndTime;
    }

    /**
     * 模板方法模式，由该方法定义算法的骨架，具体某一步骤的实现则由子类定义
     * 好处是，在统一隔离了不变处（算法骨架）与易变处（具体步骤实现）的同时，提供了扩展点。
     *
     */
    public ArrayList<RepayCycle> generateSchedule(int totalCycleAmount) {
        ArrayList<RepayCycle> repayCycles = new ArrayList<RepayCycle>();
        Date currentDay = timeRange.getBegin();
        while (!currentDay.after(timeRange.getEnd())) {
            if (DateUtils.isSameDay(currentDay, new Date())) {
                Date currentDayBeginTime = timeRange.getBegin().after(dayAllowBeginTime) ? timeRange.getBegin() : dayAllowBeginTime;
                if (timeRange.getBegin().before(dayAllowEndTime)) {
                    //由子类具体实现该一步骤
                    repayCycles.addAll(scheduleForFirstDay(currentDayBeginTime, dayAllowEndTime, totalCycleAmount));
                }
            } else {
                //由子类具体实现该一步骤
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

