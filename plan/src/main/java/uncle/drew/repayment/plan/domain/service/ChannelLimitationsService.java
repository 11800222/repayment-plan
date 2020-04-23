package uncle.drew.repayment.plan.domain.service;


import uncle.drew.repayment.plan.domain.model.plan.ChannelLimitations;

public interface ChannelLimitationsService {

    ChannelLimitations limitationsFrom(String channelCode);
}
