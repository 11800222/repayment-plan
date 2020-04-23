package uncle.drew.repayment.plan.domain.model.plan;

public class SchedulePolicy {

    protected final Integer hourIntervals;

    protected final Integer cycle;


    public SchedulePolicy(Integer hourIntervals, Integer cycle) {
        this.hourIntervals = hourIntervals;
        this.cycle = cycle;
    }

    public Integer getHourIntervals() {
        return hourIntervals;
    }

    public Integer getCycle() {
        return cycle;
    }
}
