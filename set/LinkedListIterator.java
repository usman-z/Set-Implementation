package set;

/**
 *
 * @author Usman
 */
public class LinkedListIterator {
    
    Node<T> current;

    /**
     *
     * @param newNode is the node
     */
    LinkedListIterator(Node<T> newNode) {
        this.current = newNode;
    }

    /**
     *
     * @return is true if there are more elements
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     *
     * @return is the next element
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
