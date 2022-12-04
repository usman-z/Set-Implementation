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
        
        System.out.println("--------------");
        System.out.print("The intersection is: ");
        SetContainer s1AndTest = s1.intersection(s2);
        s1AndTest.print();
        
        System.out.print("The union is: ");
        SetContainer s1OrTest = s1.union(s2);
        s1OrTest.print();
    }
    
    
}
