package java.domain.model.plan;


import java.domain.shared.ValueObject;

class ChannelInfo implements ValueObject<ChannelInfo> {

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 起始交易时间,
     */
    private String startTime;

    /**
     * 终止交易时间
     */
    private String endTime;


    public boolean sameValueAs(ChannelInfo other) {
        return false;
    }
}
