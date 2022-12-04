package set;

/**
 * The node that will be used for the LinkedList
 *@author Usman
 * @param <T> is the type
 */
public class Node<T> {
     
    Node<T> next;
    T element;
    
    public Node(){
        this(null, null);
    }
     
    /**
     * 
     * @param newElement is the new element
     */
    public Node(T newElement){
        this(newElement, null);
    } 
    
    /**
     * 
     * @param newElement is the new element
     * @param newNext is the new next node
     */
    public Node(T newElement, Node<T> newNext){
        this.element = newElement;
        this.next = newNext;
    }
    
    /**
     * 
     * @return is the String
     */
    public String toString(){
        return this.element + "";
    }
}
