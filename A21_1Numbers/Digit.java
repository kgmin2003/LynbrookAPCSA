/**
 * Create classes for objects like clocks or angles TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Twisha Sundararajan
 * @version April 5, 2019
 * 
 * @author Period - 5
 * @author Assignment - Digit - Numbers
 * 
 * @author Sources - Collaborators
 */
public class Digit
{
    private int base;

    private int value;


    /**
     * constructs a default digit
     */
    public Digit()
    {
        base = 10;
        value = 0;
    }


    /**
     * constructs a specified digit
     * 
     * @param value
     *            value of digit
     * @param base
     *            base of digit
     */
    public Digit( int value, int base )
    {
        this.value = value;
        this.base = base;
    }


    /**
     * converts the digit to a string
     * @return String c
     */
    public String toString()
    {
        if ( value < 10 )
        {
            return value + "";
        }
        char c = (char)( value - 10 + 'A' );
        return c + "";
    }


    /**
     * 
     * increments the digit
     * 
     * @return boolean depending on whether digit is carried
     */
    public boolean increment()
    {
        if ( value < base - 1 )
        {
            value++;
            return false;
        }
        else
        {
            value = 0;
            return true;
        }
    }
}
