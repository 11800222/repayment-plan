package uncle.drew.repayment.plan.domain.model.plan.generate;

import uncle.drew.repayment.plan.domain.model.plan.RepayPlan;

public interface RepayPlanFactory   {

    RepayPlan createReplayPlan(Long userId, int totalAmount);
}
