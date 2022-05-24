package state;

public class NoonState implements State {
    private static final int startHour = 12;
    private static final int endHour = 13;
    private static final NoonState singleton = new NoonState();

    private NoonState() {}

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void doClock(Context context, int hour) {
        if (NightState.isNightHour(hour)) {
            context.changeState(NightState.getInstance());
        } else if (!NoonState.isLunchHour(hour)) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("Emergency: A safe was used (during lunch).");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("An emergency alarm went off (during lunch).");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("A normal call made (during lunch).");
    }

    @Override
    public String toString() {
        return "[Lunch]";
    }

    public static boolean isLunchHour(int hour) {
        return startHour <= hour && hour < endHour;
    }
}
