package uncle.drew.repayment.plan.domain.model.bill;

import uncle.drew.repayment.plan.domain.model.plan.RepayPlan;

public interface BillBaseRepository {

    void save(RepayPlan repayPlan);
}
