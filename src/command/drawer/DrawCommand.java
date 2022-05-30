package command.drawer;

import command.command.Command;

import java.awt.*;

public class DrawCommand implements Command {
    protected final Drawable drawable;
    protected final Point position;

    public DrawCommand(final Drawable drawable, final Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
