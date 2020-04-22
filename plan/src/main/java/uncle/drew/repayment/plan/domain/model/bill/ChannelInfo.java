package uncle.drew.repayment.plan.domain.model.bill;


import uncle.drew.repayment.plan.domain.shared.ValueObject;

import java.util.Date;

public class ChannelInfo implements ValueObject<ChannelInfo> {

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 起始交易时间,
     */
    private Date startTime;

    /**
     * 终止交易时间
     */
    private Date endTime;

    private int minConsumeAmount;

    private int maxConsumeAmount;


    @Override
    public boolean sameValueAs(ChannelInfo other) {
        return false;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getMinConsumeAmount() {
        return minConsumeAmount;
    }

    public int getMaxConsumeAmount() {
        return maxConsumeAmount;
    }
}
