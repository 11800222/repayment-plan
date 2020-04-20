package uncle.drew.repayment.plan.domain.model.bill;



import uncle.drew.repayment.plan.domain.shared.Entity;

import java.util.Date;

public class PlanBill implements Entity {

    private Long id;

    private Long planId;

    private Long tradeAmount;

    private Date executionTime;

    @Override
    public boolean sameIdentityAs(Object other) {
        return false;
    }
}
