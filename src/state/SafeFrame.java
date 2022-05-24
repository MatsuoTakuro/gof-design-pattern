package state;

import java.awt.*;

public class SafeFrame extends Frame implements Context {
    private final TextField textClock = new TextField(60);
    private final TextArea textScreen = new TextArea(10, 60);
    private final Button buttonUse = new Button("Use Safe");
    private final Button buttonAlarm = new Button("Emergency Alarm");
    private final Button buttonPhone = new Button("Normal Call");
    private final Button buttonExit = new Button("Exit");

    private State state = DayState.getInstance();

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));
    }

    @Override
    public void setClock(int hour) {
        String clockString = String.format("Current time is %02d:00.", hour);
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println("State changed from " + this.state + " to " + state);
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
