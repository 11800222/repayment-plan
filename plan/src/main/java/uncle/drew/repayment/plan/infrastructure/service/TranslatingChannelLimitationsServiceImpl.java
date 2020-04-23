package uncle.drew.repayment.plan.infrastructure.service;


import uncle.drew.repayment.plan.domain.model.plan.AllocateLimits;
import uncle.drew.repayment.plan.domain.model.plan.ChannelLimitations;
import uncle.drew.repayment.plan.domain.service.ChannelLimitationsService;

import javax.annotation.Resource;

public class TranslatingChannelLimitationsServiceImpl implements ChannelLimitationsService {

    @Resource
    private ChannelAdapter channelAdapter;

    @Override
    public ChannelLimitations limitationsFrom(String channelCode) {
        return null;
    }
}
