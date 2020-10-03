/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author TODO Twisha Sundararajan
 * @version TODO August 30, 2018
 * @author Period: TODO 5
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: TODO list collaborators
 */
public class Book
{
    // TODO implement data fields

    private int numPages;

    private int currentPage;


    // TODO implement constructor
    /** book constructor */
    public Book( int val )
    {
        /** set pages to arg */
        numPages = val;
        /** set currentPage to 1 */
        currentPage = 1;
    }

    // TODO implement methods


    /**
     * getter for numPages
     * 
     * @return the number of pages: should be integer in the book constructor
     */
    public int getNumPages()
    {
        return numPages;
    }


    /**
     * getter for currentPage
     * 
     * @return the current page after increments starting from 1
     */
    public int getCurrentPage()
    {
        return currentPage;
    }


    /**
     * setter for numPages
     * 
     * @param numPages
     *            number of pages in the book
     */
    public void setNumPages( int numPages )
    {
        this.numPages = numPages;
    }


    /**
     * setter for currentPage
     * 
     * @param currentPage
     *            the page after increments starting from 1
     */
    public void setCurrentPage( int currentPage )
    {
        this.currentPage = currentPage;
    }


    /** increment page method */
    public void nextPage()
    {
        if ( currentPage < numPages )
        {
            currentPage++;
        }
    }
}
