package uncle.drew.repayment.plan.domain.model.bill;


import common.model.Entity;

import java.util.Date;

public class BillBase extends Entity {

    private Long planId;

    private Long tradeAmount;

    private Date executionTime;

    private BillState billState;

    private String repayCardId;

    private String channelCode;

}
