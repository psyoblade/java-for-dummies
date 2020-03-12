package me.suhyuk.ej2nd.o14;

public class ImmutablePublicFieldTime {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;

    public ImmutablePublicFieldTime(int hour, int minute) {
        if (hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour);
        if (minute >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Minute: " + minute);
        this.hour = hour;
        this.minute = minute;
    }
}
