import Interfaces.container.IKeeperItems;
import Interfaces.exceptions.EmptyException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        IKeeperItems<Integer> full = new Chest(a);
        IKeeperItems<Integer> empty = new Chest();

        try {
            System.out.println(empty.take());
        } catch (EmptyException e) {
            System.out.println("Empty really empty!");
        }
        while (true) {
            try {
                System.out.println(full.take());
            } catch (EmptyException e) {
                System.out.println("Full now empty!");
                break;
            }

        }
    }
}
