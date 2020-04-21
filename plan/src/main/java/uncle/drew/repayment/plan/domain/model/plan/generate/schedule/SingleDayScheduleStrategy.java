package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import java.util.ArrayList;
import java.util.Date;

/**
 * 策略模式。此处使用该模式，使逻辑更符合该类的作用，易于理解，提高了代码可读性
 */
public interface SingleDayScheduleStrategy {
    ArrayList<Date> schedule(int hourIntervals, int cycle, TimeRange timeRange);
}
