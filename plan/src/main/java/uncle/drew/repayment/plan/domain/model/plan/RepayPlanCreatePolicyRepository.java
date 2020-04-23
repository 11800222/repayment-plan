package uncle.drew.repayment.plan.domain.model.plan;

public interface RepayPlanCreatePolicyRepository {

    RepayPlanCreatePolicy get();

    void save(RepayPlanCreatePolicy repayPlanCreatePolicy);
}
