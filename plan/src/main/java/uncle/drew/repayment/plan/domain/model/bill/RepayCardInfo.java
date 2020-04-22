package uncle.drew.repayment.plan.domain.model.bill;


import uncle.drew.repayment.plan.domain.shared.ValueObject;

import java.util.Date;

public class RepayCardInfo implements ValueObject<RepayCardInfo> {
    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 信用卡账单日
     */
    private Date billDate;

    /**
     * 信用卡还款日
     */
    private Date repaymentDate;


    @Override
    public boolean sameValueAs(RepayCardInfo other) {
        return false;
    }

    public String getCardNo() {
        return cardNo;
    }

    public Date getBillDate() {
        return billDate;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }
}
