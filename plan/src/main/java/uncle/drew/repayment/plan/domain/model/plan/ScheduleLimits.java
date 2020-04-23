package uncle.drew.repayment.plan.domain.model.plan;

import java.util.Date;

public class ScheduleLimits {

    protected final Date dayAllowBeginTime;

    protected final Date dayAllowEndTime;

    public ScheduleLimits(Date dayAllowBeginTime, Date dayAllowEndTime) {
        this.dayAllowBeginTime = dayAllowBeginTime;
        this.dayAllowEndTime = dayAllowEndTime;
    }

    public Date getDayAllowBeginTime() {
        return dayAllowBeginTime;
    }

    public Date getDayAllowEndTime() {
        return dayAllowEndTime;
    }
}
