package uncle.drew.repayment.plan.domain.model.bill;


import common.model.Entity;

import java.util.Date;

public class BillBase extends Entity {

    private Long planId;

    private Long userId;

    private Long tradeAmount;

    private Date executionTime;

    private BillState billState;

    private Long repayCardId;

    private String channelCode;


    public BillBase(Long planId, Long tradeAmount, Date executionTime, BillState billState) {
        this.planId = planId;
        this.tradeAmount = tradeAmount;
        this.executionTime = executionTime;
        this.billState = billState;
    }

    public void setRepayCardId(Long repayCardId) {
        this.repayCardId = repayCardId;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
