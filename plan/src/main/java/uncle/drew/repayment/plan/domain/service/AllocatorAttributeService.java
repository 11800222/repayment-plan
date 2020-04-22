package uncle.drew.repayment.plan.domain.service;


import uncle.drew.repayment.plan.domain.model.plan.generate.allocate.AllocateStrategy;
import uncle.drew.repayment.plan.domain.model.plan.generate.allocate.AmountLimits;

public interface AllocatorAttributeService {

    AmountLimits amountLimitsFrom(String channelCode);

    AllocateStrategy allocateStrategy();
}
