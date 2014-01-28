package war.webapp.DAO;


public class BookNotFoundException extends Exception {

    public BookNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>BookNotFoundException</code> with the specified
     * message and root cause.
     *
     * @param msg the detail message.
     * @param t root cause
     */
    public BookNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
