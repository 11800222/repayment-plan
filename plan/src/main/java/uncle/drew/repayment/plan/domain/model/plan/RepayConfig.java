package uncle.drew.repayment.plan.domain.model.plan;


import uncle.drew.repayment.plan.domain.shared.ValueObject;

import java.math.BigDecimal;
import java.util.List;

public class RepayConfig implements ValueObject<RepayConfig> {


    private final Integer hourIntervals;

    private final Integer cycle;

    private final List<String> consumeSplitScales;

    private final BigDecimal repayBillFloatUp;

    private final BigDecimal repayBillFloatDown;

    public RepayConfig(Integer hourIntervals, Integer cycle, List<String> consumeSplitScales, BigDecimal repayBillFloatUp, BigDecimal repayBillFloatDown) {
        this.hourIntervals = hourIntervals;
        this.cycle = cycle;
        this.consumeSplitScales = consumeSplitScales;
        this.repayBillFloatUp = repayBillFloatUp;
        this.repayBillFloatDown = repayBillFloatDown;
    }

    @Override
    public boolean sameValueAs(RepayConfig other) {
        return false;
    }



    public Integer getHourIntervals() {
        return hourIntervals;
    }

    public Integer getCycle() {
        return cycle;
    }

    public List<String> getConsumeSplitScales() {
        return consumeSplitScales;
    }

    public BigDecimal getRepayBillFloatUp() {
        return repayBillFloatUp;
    }

    public BigDecimal getRepayBillFloatDown() {
        return repayBillFloatDown;
    }
}
