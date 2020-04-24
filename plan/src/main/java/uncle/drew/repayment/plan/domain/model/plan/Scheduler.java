package uncle.drew.repayment.plan.domain.model.plan;

import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


public abstract class Scheduler {

    protected final SchedulePolicy schedulePolicy;

    protected final ScheduleLimits scheduleLimits;

    /**
     * 这些参数能作为AbstractBillTimeScheduler的字段，是因为它们能体现出AbstractBillTimeScheduler的自身属性
     */
    public Scheduler(SchedulePolicy schedulePolicy, ScheduleLimits scheduleLimits) {
        this.schedulePolicy = schedulePolicy;
        this.scheduleLimits = scheduleLimits;
    }


    /**
     * 模板方法模式，由该方法定义算法的骨架，具体某一步骤的实现则由子类定义
     * 好处是，在统一隔离了不变处（算法骨架）与易变处（具体步骤实现）的同时，提供了扩展点。
     */
    public ArrayList<RepayPlanCycle> generateSchedule(Date beginDate, Date endDate, Integer totalCycleAmount) {
        TimeSpan timeSpan = new TimeSpan(beginDate, endDate);
        ArrayList<RepayPlanCycle> repayPlanCycles = new ArrayList<RepayPlanCycle>();
        Date currentDay = timeSpan.getBegin();
        while (!currentDay.after(timeSpan.getEnd())) {
            ArrayList<RepayPlanCycle> currentDayCycle = null;
            if (DateUtils.isSameDay(currentDay, new Date())) {
                Date currentDayBeginTime = timeSpan.getBegin().after(scheduleLimits.getDayAllowBeginTime()) ? timeSpan.getBegin() : scheduleLimits.getDayAllowBeginTime();
                if (timeSpan.getBegin().before(scheduleLimits.getDayAllowEndTime())) {
                    //由子类具体实现该一步骤
                    currentDayCycle = scheduleForFirstDay(currentDayBeginTime, scheduleLimits.getDayAllowEndTime(), totalCycleAmount);
                }
            } else {
                //由子类具体实现该一步骤
                currentDayCycle = scheduleForSingleDay(scheduleLimits.getDayAllowBeginTime(), scheduleLimits.getDayAllowEndTime(), totalCycleAmount);
            }
            if (currentDayCycle != null) {
                repayPlanCycles.addAll(currentDayCycle);
                if (totalCycleAmount != null) {
                    totalCycleAmount = totalCycleAmount - currentDayCycle.size();
                }
            }
            DateUtils.addDays(currentDay, 1);
        }
        return repayPlanCycles;
    }

    abstract ArrayList<RepayPlanCycle> scheduleForFirstDay(Date begin, Date end, Integer leftTotalCycleAmount);


    abstract ArrayList<RepayPlanCycle> scheduleForSingleDay(Date begin, Date end, Integer leftTotalCycleAmount);
}

