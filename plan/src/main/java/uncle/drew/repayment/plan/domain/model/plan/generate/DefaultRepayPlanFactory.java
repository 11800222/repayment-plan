package uncle.drew.repayment.plan.domain.model.plan.generate;

import uncle.drew.repayment.plan.domain.model.bill.ChannelInfo;
import uncle.drew.repayment.plan.domain.model.bill.RepayCardInfo;
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

    /**
     * 三个入参代表了三个概念（渠道、还款卡、还款配置），这三个概念均有自己的聚合的在其他上下文中，
     * 但这里不直接引用其聚合根，而是使用值对象代表了其在本上下文中的概念映射，因为对于本上下文，只关心其值对象中属性范围内的概念
     * 值对象将在应用服务中被构造并传入
     */
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
