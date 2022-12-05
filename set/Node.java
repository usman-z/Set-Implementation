package set;

/**
 * Set Implementation
 * @author Usman Zia, Danial Afzal, Callie Hampton, Khawaja Waheed
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
    
}