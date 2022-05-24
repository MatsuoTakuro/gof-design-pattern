package state;

public class NightState implements State {
    private static final int startHour = 21;
    private static final int endHour = 8;
    private static final NightState singleton = new NightState();

    private NightState() {}

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void doClock(Context context, int hour) {
        if (NoonState.isLunchHour(hour)) {
            context.changeState(NoonState.getInstance());
        } else if (!isNightHour(hour)) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("Emergency: A safe was used!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("An emergency alarm went off (at night).");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("A night call was recorded.");
    }

    @Override
    public String toString() {
        return "[Night]";
    }

    public static boolean isNightHour(int hour) {
        return hour < endHour || startHour <= hour;
    }
}
