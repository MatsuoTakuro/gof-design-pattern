package state;

public class UrgentState implements State {
    private static final UrgentState singleton = new UrgentState();

    private UrgentState() {}

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void doClock(Context context, int hour) {
        // Nothing in here.
        // NOTE: No way to get back to normal.
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("Emergency: A safe was used(in an emergency)!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("An emergency alarm went off (in an emergency).");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("A night call was recorded(in an emergency).");
    }

    @Override
    public String toString() {
        return "[Urgent]";
    }
}
