package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

public class ScheduleStrategy {


    protected final Integer hourIntervals;

    protected final Integer cycle;

    public ScheduleStrategy(Integer hourIntervals, Integer cycle) {
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
