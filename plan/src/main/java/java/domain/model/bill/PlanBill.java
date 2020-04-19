package java.domain.model.bill;

import domain.shared.Entity;

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
