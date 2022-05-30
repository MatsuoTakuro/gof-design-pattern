package command.drawer;

import command.command.Command;

import java.awt.*;

public class ColorCommand implements Command {
    protected Drawable drawable;
    private final Color color;

    public ColorCommand(final Drawable drawable, final Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
