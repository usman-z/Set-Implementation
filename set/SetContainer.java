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
        return header.element == null;
    }
    
    /**
     *  Make the Set logically empty.
     */
    public void makeEmpty() {
        header = new Node<>(null);
        this.cardinality = 0;
    }    
   
    /**
     * This method uses the head node of any LinkedList, and returns that sorted List (i.e., the head node to that sorted list).
     * The Sorting process is as follows: Take all the elements from the LinkedList and place them into an Array.
     * Sort that array, and Turn that Sorted array back to a LinkedList. -> (A very tricky approach, but I,Usman Zia, came up with it for a LeetCode question)
     * @return head node of sorted LinkedList
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
     * This method turns elements of an array into a LinkedList.
     * @param array, the array
     * @return node, the head of the created LinkedList
     */
    private Node<T> node(ArrayList<T> array){
        Node<T> answer = new Node<>();
        nodeHelper(array, answer);
        return answer;
    }

    /**
     *  This helper method to turn elements of an array into a LinkedList.
     * @param array, the array
     * @param answer, the head node of LinkedList
     * @return node
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
     * This method take the Head node of a LinkedList, and takes takes each
     * element from that LinkedList and places it in an Array.
     * @param head, (to be sorted)LinkedList's head node
     * @param array, An array, where all the elements from the list can be placed
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
     * This method cuts the first element from the array, and return that Array (used for recursion step)
     * @param array
     * @return array, same array without first element
     */
    private ArrayList fixArray(ArrayList<T> array){
        ArrayList<T> answer = new ArrayList<>();

        for(int i = 1; i < array.size();i++){
            answer.add(array.get(i));
        }

        return answer;
    } 

}