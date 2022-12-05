package set;

/**
 *
 * @author Usman
 */
public class Set {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SetContainer s1 = new SetContainer();
        try {
            s1.insert(1);
            s1.insert(5);
            s1.insert(77);
            s1.insert(23);
            s1.insert(34);

        } catch (SetException e) {
            System.out.println(e.toString());
        }

        s1.print();
        
        setIterator<Integer> itr1 = s1.first();
        for (;itr1.hasNext();) {
            System.out.println(itr1.next());
        }

        SetContainer s2 = new SetContainer();
        try {
            s2.insert(77);
            s2.insert(38);
            s2.insert(1);
            s2.insert(29);
            s2.insert(45);
            s2.insert(6);
            s2.insert(34);
        } catch (SetException e) {
            System.out.println(e.toString());
        }

        s2.print();
        
        setIterator<Integer> itr2 = s2.first();
        for (;itr2.hasNext();) {
            System.out.println(itr2.next());
        }
        
        System.out.println("--------------");
        System.out.print("The intersection is: ");
        SetContainer s1AndTest = s1.intersection(s2);
        s1AndTest.print();
        
        System.out.print("The union is: ");
        SetContainer s1OrTest = s1.union(s2);
        s1OrTest.print();
        
        System.out.println("--------------");
        
        System.out.print("The cardinality of s1 is: ");
        int s1Card = s1.getCardinality();
        System.out.println(s1Card);
        
        System.out.print("The cardinality of s2 is: ");
        int s2Card = s2.getCardinality();
        System.out.println(s2Card);
        
        System.out.println("--------------");
        
        System.out.print("The last node of s1 is: ");
        Node s1Find = s1.findLast();
        System.out.println(s1Find);
        
        System.out.print("The last node of s2 is: ");
        Node s2Find = s2.findLast();
        System.out.println(s2Find);
        
        System.out.println("--------------");
        
        System.out.print("s1 Contains 29: ");
        boolean s1Con = s1.contains(29);
        System.out.println(s1Con);
        
        System.out.print("s2 Contains 29: ");
        boolean s2Con = s2.contains(29);
        System.out.println(s2Con);
        
        System.out.println("--------------");
        
        System.out.println("Testing clear and inserting new: ");
        
        s1.print();
        
        s1.clear();
        
        s1.print();
        
        s1.insert(90);
        s1.insert(15);
        s1.insert(44);
        
        s1.print();
    }
    
    
}
