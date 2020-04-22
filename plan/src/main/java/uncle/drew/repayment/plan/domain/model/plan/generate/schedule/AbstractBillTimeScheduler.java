package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import org.apache.commons.lang3.time.DateUtils;
import uncle.drew.repayment.plan.domain.model.plan.RepayCycle;

import java.util.ArrayList;
import java.util.Date;


public abstract class AbstractBillTimeScheduler {

    protected final ScheduleLimits scheduleLimits;

    protected final ScheduleStrategy scheduleStrategy;

    /**
     * 这些参数能作为AbstractBillTimeScheduler的字段，是因为它们能体现出AbstractBillTimeScheduler的自身属性
     */
    public AbstractBillTimeScheduler(ScheduleLimits scheduleLimits, ScheduleStrategy scheduleStrategy) {
        this.scheduleLimits = scheduleLimits;
        this.scheduleStrategy = scheduleStrategy;
    }

    /**
     * 模板方法模式，由该方法定义算法的骨架，具体某一步骤的实现则由子类定义
     * 好处是，在统一隔离了不变处（算法骨架）与易变处（具体步骤实现）的同时，提供了扩展点。
     */
    public ArrayList<RepayCycle> generateSchedule(int totalCycleAmount, Date beginDate, Date endDate) {
        TimeRange timeRange = new TimeRange(beginDate, endDate);
        ArrayList<RepayCycle> repayCycles = new ArrayList<RepayCycle>();
        Date currentDay = timeRange.getBegin();
        while (!currentDay.after(timeRange.getEnd())) {
            if (DateUtils.isSameDay(currentDay, new Date())) {
                Date currentDayBeginTime = timeRange.getBegin().after(scheduleLimits.getDayAllowBeginTime()) ? timeRange.getBegin() : scheduleLimits.getDayAllowBeginTime();
                if (timeRange.getBegin().before(scheduleLimits.getDayAllowEndTime())) {
                    //由子类具体实现该一步骤
                    repayCycles.addAll(scheduleForFirstDay(currentDayBeginTime, scheduleLimits.getDayAllowEndTime(), totalCycleAmount));
                }
            } else {
                //由子类具体实现该一步骤
                repayCycles.addAll(scheduleForSingleDay(scheduleLimits.getDayAllowBeginTime(), scheduleLimits.getDayAllowEndTime(), totalCycleAmount));
            }
            DateUtils.addDays(currentDay, 1);
            totalCycleAmount = totalCycleAmount - repayCycles.size();
        }
        return repayCycles;
    }

    abstract ArrayList<RepayCycle> scheduleForFirstDay(Date begin, Date end, Integer leftTotalCycleAmount);


    abstract ArrayList<RepayCycle> scheduleForSingleDay(Date begin, Date end, Integer leftTotalCycleAmount);
}

