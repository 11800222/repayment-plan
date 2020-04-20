package uncle.drew.repayment.plan.domain.model.plan.generate.schedule;

import org.apache.commons.lang3.time.DateUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class TimeRange {
    private final Date begin;
    private final Date end;

    TimeRange(Date begin, Date end) {
        if (begin.after(end)) {
            throw new IllegalArgumentException("开始时间大于结束时间");
        }
        if (begin.before(new Date())) {
            throw new IllegalArgumentException("开始时间已过去");
        }
        this.begin = begin;
        this.end = end;
    }

    Date getBegin() {
        return begin;
    }

    Date getEnd() {
        return end;
    }

    Boolean isSameDay() {
        return DateUtils.isSameDay(begin, end);
    }

    Long daysApart() {
        return ChronoUnit.DAYS.between(date2LocalDate(begin), date2LocalDate(end));
    }


    private LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        return zdt.toLocalDate();
    }
}
