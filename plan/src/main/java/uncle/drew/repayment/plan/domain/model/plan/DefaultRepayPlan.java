package uncle.drew.repayment.plan.domain.model.plan;

import uncle.drew.repayment.plan.domain.shared.Entity;

import java.util.List;

public class DefaultRepayPlan implements RepayPlan, Entity {

    private Long id;

    private List<RepayCycle> repayCycles;

    private PlanState planState;

    public DefaultRepayPlan() {
    }

    @Override
    public boolean sameIdentityAs(Object other) {
        return false;
    }
}
