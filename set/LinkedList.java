package set;

/**
 *
 * @author Usman
 */
public class LinkedList<T> {
    
    private Node<T> header = new Node<>();
    
    private int size;

    public LinkedList() {
        this.header = new Node<>(null);
        this.size = 0;
    }

    /**
     *
     * @return is true if empty
     */
    public boolean isEmpty() {
        return header.next == null;
    }

    public void makeEmpty() {
        header.next = null;
        this.size = 0;
    }

    /**
     *
     * @return is the new iterator
     */
    public LinkedListIterator<T> zeroth() {
        return new LinkedListIterator<>(header);
    }

    /**
     *
     * @param item is the item to insert
     * @param position is the position prior to the newly inserted item
     */
    public void insert(T item, LinkedListIterator<T> position) {
        if (position != null && position.current != null) {
            position.current.next = new Node<>(item, position.current.next);
            this.size++;
        }
    }

    /**
     *
     * @param item is the item to search for
     * @return is the iterator
     */
    public LinkedListIterator<T> find(T item) {
        Node<T> ref = header.next;

        while (ref != null && !ref.element.equals(item)) {
            ref = ref.next;
        }

        return new LinkedListIterator<>(ref);
    }

    /**
     *
     * @param item is the item to search for
     * @return appropriate iterator if the item is found. Otherwise, the
     * iterator corresponding to the last element in the list is returned.
     */
    public LinkedListIterator<T> findPrevious(T item) {
        Node<T> ref = header;

        while (ref.next != null && !ref.next.element.equals(item)) {
            ref = ref.next;
        }

        return new LinkedListIterator<>(ref);
    }

    /**
     *
     * @param item is the item to remove
     */
    public void remove(T item) {
        LinkedListIterator<T> p = findPrevious(item);

        if (p.current.next != null) {
            p.current.next = p.current.next.next;
            this.size--;
        }
    }

    /**
     *
     * @return is the size
     */
    public int getSize() {
        return this.size;
    }

}
