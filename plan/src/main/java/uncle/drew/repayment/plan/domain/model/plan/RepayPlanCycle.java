package uncle.drew.repayment.plan.domain.model.plan;

import uncle.drew.repayment.plan.domain.model.bill.BillConsume;
import uncle.drew.repayment.plan.domain.model.bill.BillRepay;

import java.util.ArrayList;
import java.util.Date;

public class RepayPlanCycle {
    private final ArrayList<BillConsume> consumes;

    private final BillRepay billRepay;

    private final int cycle;

    public RepayPlanCycle(ArrayList<Date> times, int cycle, BillRepay billRepay) {
        this.billRepay = billRepay;
        //todo: ArrayList<Date> 转 ArrayList<PlanBill>
        this.consumes = null;
        this.cycle = 1;
    }

    public int getRepayAmount() {
        return 0;
    }
}
