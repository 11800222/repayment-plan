package uncle.drew.repayment.plan.domain.model.bill;

import java.math.BigDecimal;
import java.util.Date;

public class BillConsume extends BillBase {

    /**
     * 消费费率
     */
    private BigDecimal consumeRate;

    public BillConsume(Long planId, Long tradeAmount, Date executionTime, BillState billState) {
        super(planId, tradeAmount, executionTime, billState);
    }
}
