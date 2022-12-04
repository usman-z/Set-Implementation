package set;

/**
 * The node that will be used for the LinkedList
 * @author Usman
 */
public class Node<T> {
     
    private Node<T> next;
    private T element;
    
    public Node(){
        this(null, null);
    }     
    
    public Node(T newElement){
        this(newElement, null);
    } 
    
    public Node(T newElement, Node<T> newNext){
        this.element = newElement;
        this.next = newNext;
    } 
}