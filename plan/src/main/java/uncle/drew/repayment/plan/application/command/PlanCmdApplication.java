package uncle.drew.repayment.plan.application.command;


import uncle.drew.repayment.plan.domain.model.plan.*;
import uncle.drew.repayment.plan.domain.service.ChannelLimitationsService;
import uncle.drew.repayment.plan.domain.service.RepayPlanBuilder;

import javax.annotation.Resource;
import java.util.Date;

public class PlanCmdApplication {

    @Resource
    private ChannelLimitationsService channelLimitationsService;

    @Resource
    private RepayPlanCreatePolicyRepository repayPlanCreatePolicyRepository;

    @Resource
    private RepayPlanRepository repayPlanRepository;

    public RepayPlan createNewPlan(
            Long userId,
            Long cardId,
            String channelCode,
            Date begin,
            Date ends,
            Long totalPlanAmount,
            int totalCycle) {
        RepayPlanCreatePolicy repayPlanCreatePolicy =
                repayPlanCreatePolicyRepository.get();

        ChannelLimitations channelLimitations =
                channelLimitationsService.limitationsFrom(channelCode);

        RepayPlanBuilder repayPlanBuilder =
                new RepayPlanBuilder(
                        repayPlanCreatePolicy.getSchedulePolicy(),
                        channelLimitations.getScheduleLimits(),
                        repayPlanCreatePolicy.getAllocatePolicy(),
                        channelLimitations.getAllocateLimits());

        RepayPlan replayPlan =
                repayPlanBuilder.createReplayPlan(
                        userId,
                        cardId,
                        totalPlanAmount,
                        channelCode,
                        totalCycle,
                        new TimeSpan(begin, ends));

        repayPlanRepository.save(replayPlan);
        return replayPlan;
    }
}
