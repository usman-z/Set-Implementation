package set;

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
     */    
    public SetContainer(T element) {
        this.cardinality++;
        header = new Node<>(element);
    }
    

    /**
     *
     * @param set to take the union with
     * @return the union of the two sets
     * @throws SetException
     */
//    public SetContainer union(SetContainer set) throws SetException {
//        SetContainer unionSet = new SetContainer();
//
//        int marker1 = 0, marker2 = 0;
//
//        while (marker1 < this.cardinality && marker2 < set.cardinality) {
//            if (elements[marker1] < set.elements[marker1]) {
//                unionSet.insert(elements[marker1]);
//                marker1++;
//            } else if (elements[marker1] == set.elements[marker2]) {
//                unionSet.insert(elements[marker1]);
//                marker1++;
//                marker2++;                                                        NEED TO FIX!
//            } else {
//                unionSet.insert(set.elements[marker2]);
//                marker2++;
//            }
//        }
//
//        for (; marker1 < cardinality; marker1++) {
//            unionSet.insert(elements[marker1]);
//        }
//
//        for (; marker2 < set.cardinality; marker2++) {
//            unionSet.insert(set.elements[marker2]);
//        }
//
//        return unionSet;
//    }

    /**
     *
     * @param set to take the intersection with
     * @return the intersection of the two sets
     * @throws SetException
     */
//    public SetContainer intersection(SetContainer set) throws SetException {
//        SetContainer intersectionSet = new SetContainer(Math.min(this.cardinality, set.cardinality));
//
//        int marker1 = 0, marker2 = 0;
//
//        while (marker1 < this.cardinality || marker2 < set.cardinality) {
//            if (this.elements[marker1] < set.elements[marker2]) {
//                marker1++;
//            } else if (this.elements[marker1] == set.elements[marker2]) {         NEED TO FIX!
//                intersectionSet.insert(this.elements[marker1]);
//                marker1++;
//                marker2++;
//            } else {
//                marker2++;
//            }
//        }
//
//        return intersectionSet;
//
//    }

    /**
     * 
     */
    public void insert(T newElement){
        if (!contains(newElement)) {
            Node<T> ref = findLast();
            
            ref.next = new Node<>(newElement);
        }
    }
    
    /**
     * 
     */    
    public Node<T> findLast() {
        Node<T> ref = header;

        while(ref != null && ref.element != null && ref.next != null){
            ref = ref.next;
        }

        return ref;
    }    
    
    

    /**
     * 
     */
    public boolean contains(T testElement) {

        while (header != null && header.element != null) {
            if (header.element.compareTo(testElement) == 0)
                return true;
            
            header = header.next;
        }
        
        return false;
    }

    /**
     * 
     */
    public void clear() {
        cardinality = 0;
        header = null;
    }

    /**
     * 
     */
    public int getCardinality() {
        return this.cardinality;
    }

    /**
     * Print the content of the set
     */
    public void print() {
        while (header != null && header.element != null) {
            System.out.print(header.element + " ");
            header = header.next;
        }
        System.out.println();
    }

}

/*
    public SetContainer(int maxSize) {
        this.cardinality = 0;
        this.maxSize = maxSize;
        this.elements = new int[maxSize];
    }


    public SetContainer union(SetContainer set) throws SetException {
        SetContainer unionSet = new SetContainer(this.maxSize + set.maxSize);

        int marker1 = 0, marker2 = 0;

        while (marker1 < this.cardinality && marker2 < set.cardinality) {
            if (elements[marker1] < set.elements[marker1]) {
                unionSet.insert(elements[marker1]);
                marker1++;
            } else if (elements[marker1] == set.elements[marker2]) {
                unionSet.insert(elements[marker1]);
                marker1++;
                marker2++;
            } else {
                unionSet.insert(set.elements[marker2]);
                marker2++;
            }
        }

        for (; marker1 < cardinality; marker1++) {
            unionSet.insert(elements[marker1]);
        }

        for (; marker2 < set.cardinality; marker2++) {
            unionSet.insert(set.elements[marker2]);
        }

        return unionSet;
    }


    public SetContainer intersection(SetContainer set) throws SetException {
        SetContainer intersectionSet = new SetContainer(Math.min(this.cardinality, set.cardinality));

        int marker1 = 0, marker2 = 0;

        while (marker1 < this.cardinality || marker2 < set.cardinality) {
            if (this.elements[marker1] < set.elements[marker2]) {
                marker1++;
            } else if (this.elements[marker1] == set.elements[marker2]) {
                intersectionSet.insert(this.elements[marker1]);
                marker1++;
                marker2++;
            } else {
                marker2++;
            }
        }

        return intersectionSet;

    }


    public void insert(int newElement) throws SetException {
        if (cardinality >= maxSize) {
            throw new SetException("cannot insert..set full");
        } else if (!contains(newElement)) {
            int marker = cardinality;

            while (marker > 0 && newElement < elements[marker - 1]) {
                elements[marker] = elements[marker - 1];
                --marker;
            }
            elements[marker] = newElement;
            cardinality++;
        }
    }


    public boolean contains(int testElement) {
        int marker;

        for (marker = 0; marker < cardinality; marker++) {
            if (testElement == elements[marker]) {
                return true;
            }
        }
        return false;
    }


    public void clear() {
        cardinality = 0;
    }


    public int getCardinality() {
        return this.cardinality;
    }


    public void print() {
        for (int marker = 0; marker < cardinality; marker++) {
            System.out.print(elements[marker] + " ");
        }
        System.out.println();
    }

}

*/