package uncle.drew.repayment.plan.domain.model.plan;

public class RepayPlanCreatePolicy {


    private  final SchedulePolicy schedulePolicy;

    private  final AllocatePolicy allocatePolicy;


    public RepayPlanCreatePolicy(SchedulePolicy schedulePolicy, AllocatePolicy allocatePolicy) {
        this.schedulePolicy = schedulePolicy;
        this.allocatePolicy = allocatePolicy;
    }

    public SchedulePolicy getSchedulePolicy() {
        return schedulePolicy;
    }

    public AllocatePolicy getAllocatePolicy() {
        return allocatePolicy;
    }
}
