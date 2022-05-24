package state;

public class NightState implements State {
    private static final NightState singleton = new NightState();

    private NightState() {}

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
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
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("A night call was recorded.");
    }

    @Override
    public String toString() {
        return "[Night]";
    }
}
