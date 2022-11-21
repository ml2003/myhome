package smart.myhome.service;

import java.util.Date;

public class DateUtils {

    public static final int SECOND_SIZE = 1000;

    public static final int MINUTE_SIZE = 60 * SECOND_SIZE;

    public static final int HOUR_SIZE = 60 * MINUTE_SIZE;

    public static final int DAY_SIZE = 24 * HOUR_SIZE;

    public static String formatMilliseconds(long ms) {
        StringBuilder result = new StringBuilder();
        if (ms > DAY_SIZE) {
            result.append(ms / DAY_SIZE).append(" д. ");
            ms %= DAY_SIZE;
        }
        if (ms > HOUR_SIZE) {
            result.append(ms / HOUR_SIZE).append(" ч. ");
            ms %= HOUR_SIZE;
        }
        if (ms > MINUTE_SIZE) {
            result.append(ms / MINUTE_SIZE).append(" мин. ");
            ms %= MINUTE_SIZE;
        }
        if (ms > SECOND_SIZE) {
            result.append(ms / SECOND_SIZE).append(" сек. ");
            ms %= SECOND_SIZE;
        }
        result.append(ms).append(" мс.");
        return result.toString();
    }

    public static String getPeriodInfo(Date begin) {
        return getPeriodInfo(begin, new Date());
    }

    public static String getPeriodInfo(Date begin, Date end) {
        final long msec = end.getTime() - begin.getTime();
        return formatMilliseconds(msec);
    }

}
