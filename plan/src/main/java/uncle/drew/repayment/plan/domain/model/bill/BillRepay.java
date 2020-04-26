package uncle.drew.repayment.plan.domain.model.bill;

import java.util.Date;

public class BillRepay extends BillBase {


    /**
     * 还款手续费
     */
    private Long repayFee;

    public BillRepay(Long planId, Long tradeAmount, Date executionTime, BillState billState) {
        super(planId, tradeAmount, executionTime, billState);
    }
}
