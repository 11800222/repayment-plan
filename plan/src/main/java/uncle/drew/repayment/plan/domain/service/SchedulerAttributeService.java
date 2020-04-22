package uncle.drew.repayment.plan.domain.service;

import uncle.drew.repayment.plan.domain.model.plan.generate.schedule.ScheduleLimits;
import uncle.drew.repayment.plan.domain.model.plan.generate.schedule.ScheduleStrategy;

public interface SchedulerAttributeService {

    ScheduleLimits amountLimitsFrom(String channelCode);

    ScheduleStrategy allocateStrategy();
}
