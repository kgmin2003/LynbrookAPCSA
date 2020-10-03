/**
 * This is a class that tests the Book class.
 *
 * @author TODO Twisha Sundararajan
 * @version TODO August 28, 2018
 * @author Period: TODO 5
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: TODO list collaborators
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {

        /** create new object */
        Book book = new Book( 3 );

        /** print number of pages */
        System.out.println( book.getNumPages() );

        /** print current page */
        System.out.println( book.getCurrentPage() );

        /** first increment + print */
        book.nextPage();
        System.out.println( book.getCurrentPage() );

        /** second increment + print */
        book.nextPage();
        System.out.println( book.getCurrentPage() );

        /** third increment should return same number */
        book.nextPage();
        System.out.println( book.getCurrentPage() );
    }
}
