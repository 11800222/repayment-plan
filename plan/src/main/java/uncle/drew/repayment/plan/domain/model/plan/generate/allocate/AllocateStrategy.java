package uncle.drew.repayment.plan.domain.model.plan.generate.allocate;

import java.math.BigDecimal;
import java.util.List;

public class AllocateStrategy {

    private final BigDecimal repayBillFloatUp;

    private final BigDecimal repayBillFloatDown;

    private final List<String> consumeSplitScales;

    protected final Integer cycle;

    public AllocateStrategy(BigDecimal repayBillFloatUp, BigDecimal repayBillFloatDown, List<String> consumeSplitScales, Integer cycle) {
        this.repayBillFloatUp = repayBillFloatUp;
        this.repayBillFloatDown = repayBillFloatDown;
        this.consumeSplitScales = consumeSplitScales;
        this.cycle = cycle;
    }


    public BigDecimal getRepayBillFloatUp() {
        return repayBillFloatUp;
    }

    public BigDecimal getRepayBillFloatDown() {
        return repayBillFloatDown;
    }

    public List<String> getConsumeSplitScales() {
        return consumeSplitScales;
    }

    public Integer getCycle() {
        return cycle;
    }
}
