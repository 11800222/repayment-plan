package uncle.drew.repayment.plan.domain.model.plan;

public class ChannelLimitations {



    private ScheduleLimits scheduleLimits;

    private AllocateLimits allocateLimits;

    public ChannelLimitations(ScheduleLimits scheduleLimits, AllocateLimits allocateLimits) {
        this.scheduleLimits = scheduleLimits;
        this.allocateLimits = allocateLimits;
    }

    public ScheduleLimits getScheduleLimits() {
        return scheduleLimits;
    }

    public AllocateLimits getAllocateLimits() {
        return allocateLimits;
    }
}
