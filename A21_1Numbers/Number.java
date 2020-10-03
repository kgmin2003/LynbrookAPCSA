import java.util.*;


/**
 * constructs s number by utilizing the digit class increments numbers and
 * converts numbers to string
 * 
 * @author Twisha Sundararajan
 * @version April 5, 2019
 * 
 * @author Period - 5
 * @author Assignment - Number - Numbers
 * 
 * @author Sources - Collaborators
 */
public class Number
{
    private int base;

    private LinkedList<Digit> value;


    /**
     * constructs a default number
     */
    public Number()
    {
        base = 10;
        value = new LinkedList<Digit>();
        value.add( new Digit( 0, 10 ) ); 
    }


    /**
     * constructs a specified number
     * 
     * @param value
     *            value of digit in number
     * @param base
     *            base of digit in number
     */
    public Number( int value, int base )
    {
        this.base = base;
        this.value = new LinkedList<Digit>();
        int rem;
        while ( value > 0 )
        {
            rem = value % base;
            value /= base;
            this.value.add( 0, new Digit( rem, base ) );
        }
    }


    /**
     * converts number into string
     * @return String str 
     */
    public String toString()
    {
        String str = "";
        for ( Digit dig : value )
        {
            str += dig.toString();
        }
        return str;
    }


    /**
     * increments number based on all digits
     */
    public void increment()
    {
        for ( int i = value.size() - 1; i >= 0; i-- )
        {
            if ( !value.get( i ).increment() )
            {
                return;
            }
        }
        value.add( 0, new Digit( 1, base ) );
    }

}
