package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import java.util.ArrayList;
import java.util.Date;

public interface SingleDayScheduleStrategy {
    ArrayList<Date> schedule(int hourIntervals, int cycle, TimeRange timeRange);
}
