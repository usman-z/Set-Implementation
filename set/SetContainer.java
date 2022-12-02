package set;

public class SetContainer <T extends Comparable> {

    private int cardinality;
    private final int maxSize;
    private final int[] elements;

    /**
     * No arg constructor
     *
     * @param maxSize
     */
    SetContainer(int maxSize) {
        this.cardinality = 0;
        this.maxSize = maxSize;
        this.elements = new int[maxSize];
    }

    /**
     *
     * @param set to take the union with
     * @return the union of the two sets
     * @throws SetException
     */
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

    /**
     *
     * @param set to take the intersection with
     * @return the intersection of the two sets
     * @throws SetException
     */
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

    /**
     *
     * @param newElement to be inserted
     * @throws SetException
     */
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

    /**
     *
     * @param testElement to be checked
     * @return true if element exists
     */
    public boolean contains(int testElement) {
        int marker;

        for (marker = 0; marker < cardinality; marker++) {
            if (testElement == elements[marker]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clear the set
     */
    public void clear() {
        cardinality = 0;
    }

    /**
     *
     * @return the cardinality of the set
     */
    public int getCardinality() {
        return this.cardinality;
    }

    /**
     * Print the content of the set
     */
    public void print() {
        for (int marker = 0; marker < cardinality; marker++) {
            System.out.print(elements[marker] + " ");
        }
        System.out.println();
    }

}
