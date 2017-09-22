

package simplebinarytree;

/**
 *
 * @author federico
 */
public class Entry {
    Object key;
    Object element;

    public Entry(Object key, Object element) {
        this.key = key;
        this.element = element;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entry other = (Entry) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return '{' + "key=" + key + ",element=" + element + '}';
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }


}
