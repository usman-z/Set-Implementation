package set;

/**
 * 
 * @author Usman
 * @param <T> is the type
 */
public class setIterator<T> {

    Node<T> current;    // Current position

    public setIterator(Node<T> theNode) {
        this.current = theNode;
    }

    /**
     * Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
     *
     * @return true if the iteration has more element
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    public T next() {
        if (current != null) {
            T element = current.element;
            current = current.next;
            return element;
        } else {
            return null;
        }
    }
}
