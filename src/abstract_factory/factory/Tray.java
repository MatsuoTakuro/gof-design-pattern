package abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Tray extends Item {
    private List<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }

    protected  List<Item> tray() {
        return tray;
    }
}
