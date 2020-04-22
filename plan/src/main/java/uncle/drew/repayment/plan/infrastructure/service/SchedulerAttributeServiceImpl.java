package uncle.drew.repayment.plan.infrastructure.service;

import uncle.drew.repayment.plan.domain.model.plan.generate.schedule.ScheduleLimits;
import uncle.drew.repayment.plan.domain.model.plan.generate.schedule.ScheduleStrategy;
import uncle.drew.repayment.plan.domain.service.SchedulerAttributeService;

public class SchedulerAttributeServiceImpl implements SchedulerAttributeService {

    @Override
    public ScheduleLimits amountLimitsFrom(String channelCode) {
        return null;
    }

    @Override
    public ScheduleStrategy allocateStrategy() {
        return null;
    }
}
