package set;

/**
 * Set Implementation
 * @author Usman Zia, Danial Afzal, Callie Hampton, Khawaja Waheed
 */

public class SetException extends RuntimeException {

    public SetException() {
        super();
    }

    /**
     *
     * @param s is the String
     */
    public SetException(String s) {
        super(s);
    }
}