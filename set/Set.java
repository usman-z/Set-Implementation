package set;

/**
 * Set Implementation
 * @author Usman Zia, Danial Afzal, Callie Hampton, Khawaja Waheed
 */

public class Set {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SetContainer s1 = new SetContainer();
        s1.insert(1);
        s1.insert(5);
        s1.insert(77);
        s1.insert(23);
        s1.insert(34);

        System.out.println("Set 1: ");
        s1.print();

        System.out.println("");

        SetContainer s2 = new SetContainer();
        s2.insert(77);
        s2.insert(38);
        s2.insert(1);
        s2.insert(29);
        s2.insert(45);
        s2.insert(6);
        s2.insert(34);

        System.out.println("Set 2: ");
        s2.print();

        System.out.println("");
        System.out.println("----------------*Testing Started*----------------");
        System.out.println("");
        System.out.print("The intersection of Set 1 and Set 2 is: ");
        SetContainer s1AndTest = s1.intersection(s2);
        s1AndTest.print();

        System.out.print("The union of Set 1 and Set 2 is: ");
        SetContainer s1OrTest = s1.union(s2);
        s1OrTest.print();

        System.out.println("");
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.println("The cardinality of Set 1 is: " + s1.getCardinality());

        System.out.println("The cardinality of Set 2 is: " + s2.getCardinality());

        System.out.println("");
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.println("Enhanced for-loop Set 1:");
        
        setIterator<Integer> itr1 = s1.first();
        for (; itr1.hasNext(); ) {
            System.out.print(itr1.next()+" ");
        }

        System.out.println("\n");
        
        System.out.println("Enhanced for-loop Set 2:");
        
        setIterator<Integer> itr2 = s2.first();
        for (; itr2.hasNext(); ) {
            System.out.print(itr2.next() + " ");
        }
        
        System.out.println("");
        
        System.out.println("");
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.print("Set 1 Contains 29: ");
        boolean s1Con = s1.contains(29);
        System.out.println(s1Con);

        System.out.print("Set 2 Contains 29: ");
        boolean s2Con = s2.contains(29);
        System.out.println(s2Con);

        System.out.println("");
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.println("Current Set 1: ");

        s1.print();
        System.out.println("");
        System.out.println("Set 1 Clearing... ");
        s1.clear();
        System.out.println("");
        System.out.println("Cleared Set 1: ");
        s1.print();
        System.out.println("Is Set 1 empty? " + s1.isEmpty());

        System.out.println("");
        System.out.println("-------------------");
        System.out.println("");

        System.out.println("Inserting 90, 15, and 44. Printing Set 1:");
        s1.insert(90);
        s1.insert(15);
        s1.insert(44);

        s1.print();
        System.out.println("");
        System.out.println("----------------*Testing Done*----------------");
    }

}
