package java.domain.model.plan;

import org.apache.commons.lang3.time.DateUtils;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BillTimeScheduler {

    private final TimeRange timeRange;

    private final int hourIntervals;

    public BillTimeScheduler(Date beginTime, Date endTime, int hourIntervals) {
        timeRange = new TimeRange(beginTime, endTime);
        this.hourIntervals = hourIntervals;
    }

    //最多可安排的时间节点数
    public int maxAssignable(Date dayAllowBeginTime, Date dayAllowEndTime) {
        int count = 0;
        Date currentDay = timeRange.getBegin();
        while (!currentDay.after(timeRange.getEnd())) {
            SingleDayScheduler dayScheduler = new SingleDayScheduler(currentDay);
            ArrayList<Date> dateArrayList = dayScheduler.schedule(hourIntervals);
            count += dateArrayList.size();
        }
        return count;
    }


    //给定天数、笔数，生成
    public ArrayList<Date> gen() {

    }


    class SingleDayScheduler {
        private final TimeRange timeRange;

         SingleDayScheduler(Date begin, Date end) {
            timeRange = new TimeRange(begin, end);
            if (!timeRange.isSameDay()) {
                throw new IllegalArgumentException("传入的开始、结束时间不在同一天");
            }
        }

        /**
         * @param hourIntervals 时间节点之间的间隔大小
         * @return 生成的时间节点集合
         */
         ArrayList<Date> schedule(int hourIntervals) {
            ArrayList<Date> times = new ArrayList<Date>();
            Date currentTime = timeRange.getBegin();
            while (currentTime.after(timeRange.getEnd())) {
                times.add(currentTime);
                currentTime = DateUtils.addHours(currentTime, hourIntervals);
            }
            return times;
        }
    }

    class TimeRange {
        private final Date begin;
        private final Date end;

        TimeRange(Date begin, Date end) {
            if (begin.after(end)) {
                throw new IllegalArgumentException("开始时间大于结束时间");
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
    }
}
