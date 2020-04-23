package uncle.drew.repayment.plan.domain.model.plan;

import common.model.Entity;

import java.util.List;

public class RepayPlan extends Entity {

    private Long id;

    private List<RepayPlanCycle> repayPlanCycles;

    private RepayPlanState repayPlanState;

    public RepayPlan() {
    }

}
