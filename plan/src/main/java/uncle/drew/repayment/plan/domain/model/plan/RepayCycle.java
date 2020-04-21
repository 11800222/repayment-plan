package uncle.drew.repayment.plan.domain.model.plan;

import uncle.drew.repayment.plan.domain.model.bill.PlanBill;

import java.util.ArrayList;
import java.util.Date;

public class RepayCycle {
    private final ArrayList<PlanBill> bills;

    private final int cycle;

    public RepayCycle(ArrayList<Date> times, int cycle) {
        //todo: ArrayList<Date> 转 ArrayList<PlanBill>
        this.bills = null;
        this.cycle = 1;
    }

    public int getRepayAmount() {
        return 0;
    }
}
