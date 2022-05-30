package command.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // Deque means a linear data structure in which elements may be appended to or removed from either end.
    private final Deque<Command> commands = new ArrayDeque<>();
    private final int UNDO_UNIT = 10;

    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    public void append(final Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // TODO: Undo for setting color is not working well.
    public void undo() {
        if (!commands.isEmpty()) {
            undoByUnit();
        }
    }

    public void clear() {
        commands.clear();
    }

    private void undoByUnit() {
        if (commands.size() > UNDO_UNIT) {
            for (int i = 0; i < UNDO_UNIT; i++) {
                commands.pop();
            }
        } else {
            commands.pop();
        }

    }
}
