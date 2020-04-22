package uncle.drew.repayment.plan.domain.model.plan.generate;

import uncle.drew.repayment.plan.domain.model.plan.RepayPlan;

import java.util.Date;

public interface RepayPlanFactory {

    RepayPlan createReplayPlan(Long userId, int totalAmount, Date beginDate, Date endDate);
}
