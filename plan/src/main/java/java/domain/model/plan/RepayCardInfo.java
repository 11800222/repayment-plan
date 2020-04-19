package java.domain.model.plan;


import domain.shared.ValueObject;

class RepayCardInfo implements ValueObject<RepayCardInfo> {
    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 信用卡账单日
     */
    private String billDate;

    /**
     * 信用卡还款日
     */
    private String repaymentDate;


    @Override
    public boolean sameValueAs(RepayCardInfo other) {
        return false;
    }
}
