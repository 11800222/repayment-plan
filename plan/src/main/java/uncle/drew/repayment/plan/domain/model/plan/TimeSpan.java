package uncle.drew.repayment.plan.domain.model.plan;

import org.apache.commons.lang3.time.DateUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeSpan {
    private final Date begin;
    private final Date end;

    public TimeSpan(Date begin, Date end) {
        if (begin.after(end)) {
            throw new IllegalArgumentException("开始时间大于结束时间");
        }
        if (begin.before(new Date())) {
            throw new IllegalArgumentException("开始时间已过去");
        }
        this.begin = begin;
        this.end = end;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public Boolean isSameDay() {
        return DateUtils.isSameDay(begin, end);
    }

    public Long daysApart() {
        return ChronoUnit.DAYS.between(date2LocalDate(begin), date2LocalDate(end));
    }


    private LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        return zdt.toLocalDate();
    }
}
