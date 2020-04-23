package uncle.drew.repayment.plan.application.command;


import uncle.drew.repayment.plan.domain.model.plan.*;
import uncle.drew.repayment.plan.domain.service.ChannelLimitationsService;
import uncle.drew.repayment.plan.domain.service.RepayPlanBuilder;

import javax.annotation.Resource;
import java.util.Date;

public class PlanCmdService {

    @Resource
    private ChannelLimitationsService channelLimitationsService;

    @Resource
    private RepayPlanCreatePolicyRepository repayPlanCreatePolicyRepository;

    public RepayPlan createNewPlan(
            Long userId, Long cardId, String channelCode,
            Date begin, Date ends, Long totalPlanAmount, Long totalCycle) {
        RepayPlanCreatePolicy repayPlanCreatePolicy = repayPlanCreatePolicyRepository.get();

        ChannelLimitations channelLimitations = channelLimitationsService.limitationsFrom(channelCode);



        return null;
    }
}
