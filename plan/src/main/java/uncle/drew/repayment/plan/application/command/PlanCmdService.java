package uncle.drew.repayment.plan.application.command;

import uncle.drew.repayment.plan.domain.model.plan.RepayPlan;

public interface PlanCmdService {

    public RepayPlan createNewPlan();
}
