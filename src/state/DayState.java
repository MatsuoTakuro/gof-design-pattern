package state;

public class DayState implements State {
    private static final DayState singleton = new DayState();

    private DayState() {}

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void doClock(Context context, int hour) {
        if (NightState.isNightHour(hour)) {
            context.changeState(NightState.getInstance());
        } else if (NoonState.isLunchHour(hour)) {
            context.changeState(NoonState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("A safe was used (during the daytime).");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("An emergency alarm went off (during the daytime).");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("A normal call made (during the daytime).");
    }

    @Override
    public String toString() {
        return "[Daytime]";
    }
}
