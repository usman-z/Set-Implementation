package set;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Set Implementation
 * @author Usman Zia, Danial Afzal, Callie Hampton, Khawaja Waheed
 */

public class SetContainer <T extends Comparable> {

    private int cardinality; // the size of Set
    Node<T> header; // begining referance of List

    /**
     * No arg constructor
     */
    public SetContainer() {
        this.cardinality = 0;
        header = new Node<>(null);
    }
    
    /**
     * Arg constructor
     * @param element is the element
     */    
    public SetContainer(T element) {
        this.cardinality = 1;
        header = new Node<>(element);
    }
    
    /**
     * Return an iterator representing the first node in the set.This operation is valid for empty lists.
     *
     * @return an iterator for the first element
     */
    public setIterator<T> first() {
        return new setIterator<>(header);
    }
    
    /**
     *
     * @param set to take the union with
     * @return the union of the two sets
     */
    public SetContainer union(SetContainer set){
        SetContainer unionSet = new SetContainer();
        Node<T> ref = this.header;

        while (ref!= null && ref.element != null) {
            if(!unionSet.contains(ref.element)){
                unionSet.insert(ref.element);
            }
            ref = ref.next;
        }

        ref = set.header;

        while (ref!= null && ref.element != null) {
            if(!unionSet.contains(ref.element)){
                unionSet.insert(ref.element);
            }
            ref = ref.next;
        }

        return unionSet;
    }

    /**
     *
     * @param set to take the intersection with
     * @return the intersection of the two sets
     * @throws SetException
     */
    public SetContainer intersection(SetContainer set) {
        SetContainer intersectionSet = new SetContainer();

        Node<T> ref1 = this.header;
        Node<T> ref2 = set.header;

        while (ref1 != null || ref2 != null) {
            
            if(ref1.element == null){
                intersectionSet.insert(ref2.element);
                ref2 = ref2.next;
            }
            
            else if(ref2.element == null){
                intersectionSet.insert(ref1.element);
                ref1 = ref1.next;
            }
            
            else{
                if (ref1.element.compareTo(ref2.element) < 0) {
                     ref1 = ref1.next;
                } else if (ref1.element.compareTo(ref2.element) == 0) { 
                    intersectionSet.insert(ref1.element);
                    ref1 = ref1.next;
                    ref2 = ref2.next;
                } else {
                    ref2 = ref2.next;
                }
            }
        }

        return intersectionSet;

    }

    /**
     * 
     * @param newElement is the new element
     */
    public void insert(T newElement){
        if (!contains(newElement)) {
            Node<T> ref = findLast();
            
            if(ref.element == null){
                ref.element = newElement;
                this.cardinality++;
            }
            else{
                ref.next = new Node<>(newElement);
                this.cardinality++;                
            }
            
            header = this.sort();
        }
    }
    
    /**
     *
     * @return is the reference
     */    
    public Node<T> findLast() {
        Node<T> ref = header;

        while(ref.element != null){
            
            if(ref.next != null)
                ref = ref.next;
            else
                break;
            
        }

        return ref;
    }    
    
    

    /**
     *
     * @param testElement is the test element
     * @return true if contains the test element, otherwise return false
     */
    public boolean contains(T testElement) {
        Node<T> ref = header;
        
        while (ref.element != null) {
            if (ref.element.compareTo(testElement) == 0)
                return true;
            
            if(ref.next != null)
                ref = ref.next;
            else
                break;
        }
        
        return false;
    }

    /**
     * Clear the cardinality and header
     */
    public void clear() {
        cardinality = 0;
        header = new Node<>(null);
    }

    /**
     * 
     * @return is the cardinality
     */
    public int getCardinality() {
        return this.cardinality;
    }

    /**
     * Print the content of the set
     */
    public void print() {
        Node<T> ref = header;
        
        while (ref.element != null) {
            System.out.print(ref.element + " ");
            
            if(ref.next != null)
                ref = ref.next;
            else
                break;
        }
        System.out.println();
    }
    
    /**
     *  Test if the Set is empty.
     * @return 
     */
    public boolean isEmpty(){
        if(header.element == null)
            return true;
        
        return false;
    }
    
    /**
     *  Make the Set logically empty.
     */
    public void makeEmpty() {
        header = new Node<>(null);
        this.cardinality = 0;
    }    
   
    /**
     * 
     * @return header if null, otherwise return the sorted array
     */
    private Node<T> sort(){
        ArrayList<T> array = new ArrayList();
        Node<T> head = this.header;
        if(head == null || head.next == null){
            return head;
        }
        else{
            assignArray(head, array);
            Collections.sort(array);

            return node(array);
        }
    }
    
    /**
     * 
     * @param array is the array
     * @return is the answer
     */
    private Node<T> node(ArrayList<T> array){
        Node<T> answer = new Node<>();
        nodeHelper(array, answer);
        return answer;
    }

    /**
     * 
     * @param array is the array
     * @param answer is the answer
     * @return is the node helper
     */
    private Node<T> nodeHelper(ArrayList<T> array, Node<T> answer){
        if(array.isEmpty()){
            return null;
        }

        if(array.size()<2){
            answer.element = array.get(0);
            ArrayList<T> a = fixArray(array);
            return nodeHelper(a, null);
        }
        else{
            answer.element = array.get(0);
            ArrayList<T> a = fixArray(array);
            answer.next = new Node<>();
            return nodeHelper(a, answer.next);
        }

    }

    /**
     * 
     * @param head is the header
     * @param array is the array
     */
    private void assignArray(Node<T> head, ArrayList<T> array){
        if(head == null){
            return;
        }

        if(head.next == null){
            array.add(head.element);
            assignArray(null, array);
        }
        else{
            array.add(head.element);
            assignArray(head.next, array);
        }

    }

    /**
     * 
     * @param array is the array
     * @return is the answer
     */
    private ArrayList fixArray(ArrayList<T> array){
        ArrayList<T> answer = new ArrayList<>();

        for(int i = 1; i < array.size();i++){
            answer.add(array.get(i));
        }

        return answer;
    } 

}