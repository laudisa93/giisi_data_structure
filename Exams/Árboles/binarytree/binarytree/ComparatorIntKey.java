

package simplebinarytree;

import java.util.Comparator;

/**
 *
 * @author federico
 */
public class ComparatorIntKey  implements Comparator {

    public int compare(Object o1, Object o2) {
        Integer int1 = (Integer)o1;
        Integer int2 = (Integer)o2;
        return int1.compareTo(int2);
    }
}
