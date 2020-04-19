package java.domain.model.plan;

import domain.shared.Entity;

import java.util.List;

public class RepayPlan implements Entity {

    private Long id;

    private Long userId;

    private RepayCardInfo repayCardInfo;

    private ChannelInfo channelCode;

    private List<Long> bills;

    private PlanState planState;

    @Override
    public boolean sameIdentityAs(Object other) {
        return false;
    }
}
