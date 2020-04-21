package uncle.drew.repayment.plan.domain.model.plan.generate;

import uncle.drew.repayment.plan.domain.model.plan.*;
import uncle.drew.repayment.plan.domain.model.plan.generate.allocate.BillAmountAllocator;
import uncle.drew.repayment.plan.domain.model.plan.generate.schedule.AbstractBillTimeScheduler;
import uncle.drew.repayment.plan.domain.model.plan.generate.schedule.DesignatedBillTimeScheduler;

import java.util.ArrayList;
import java.util.Date;

public class DefaultRepayPlanFactory implements RepayPlanFactory {
    private final ChannelInfo channelInfo;

    private final RepayCardInfo repayCardInfo;

    private final RepayConfig repayConfig;

    private AbstractBillTimeScheduler billTimeScheduler;

    private BillAmountAllocator billAmountAllocator;

    public DefaultRepayPlanFactory(ChannelInfo channelInfo, RepayCardInfo repayCardInfo, RepayConfig repayConfig) {
        this.channelInfo = channelInfo;
        this.repayCardInfo = repayCardInfo;
        this.repayConfig = repayConfig;
        billTimeScheduler = new DesignatedBillTimeScheduler(
                new Date(),
                repayCardInfo.getRepaymentDate(),
                channelInfo.getStartTime(),
                channelInfo.getEndTime(),
                repayConfig.getHourIntervals(),
                repayConfig.getCycle()
        );
        billAmountAllocator = new BillAmountAllocator(
                channelInfo.getMinConsumeAmount(),
                channelInfo.getMaxConsumeAmount(),
                repayConfig.getRepayBillFloatUp(),
                repayConfig.getRepayBillFloatDown(),
                repayConfig.getConsumeSplitScales(),
                repayConfig.getCycle());
    }

    @Override
    public RepayPlan createReplayPlan(Long userId, int totalAmount) {
        ArrayList<RepayCycle> repayCycles = billTimeScheduler.generateSchedule(totalAmount);
        billAmountAllocator.fill(repayCycles, totalAmount);
        //todo:生成计划
        DefaultRepayPlan plan = new DefaultRepayPlan();
        return plan;
    }
}
