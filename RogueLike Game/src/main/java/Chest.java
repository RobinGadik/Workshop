import Interfaces.IControlled.IAction;
import Interfaces.IControlled.INotMoveable;
import Interfaces.IControlled.IOpenable;
import Interfaces.container.ICloseable;
import Interfaces.container.IKeeperItems;
import Interfaces.exceptions.EmptyException;

import java.util.ArrayList;
import java.util.List;

public class Chest implements IAction, INotMoveable, IKeeperItems<Integer>, ICloseable, IOpenable {

    List<Integer> a;

    public Chest(List<Integer> a) {
        this.a = a;
    }
    public Chest() {
        this.a = new ArrayList<Integer>();
    }

    public Integer take() throws EmptyException {
        if (a.size() > 0) {
            int c = a.get(0);
            a.remove(0);
            return c;
        } else {
            throw new EmptyException();
        }
    }
}
