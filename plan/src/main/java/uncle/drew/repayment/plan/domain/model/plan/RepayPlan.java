package uncle.drew.repayment.plan.domain.model.plan;


import uncle.drew.repayment.plan.domain.shared.Entity;

import java.util.List;

public class RepayPlan implements Entity {

    private Long id;

    private Long userId;

    private RepayCardInfo repayCardInfo;

    private ChannelInfo channelCode;

    private List<RepayCycle> repayCycles;

    private PlanState planState;

    @Override
    public boolean sameIdentityAs(Object other) {
        return false;
    }
}
