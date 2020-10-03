/**
 * 
 *  This class tests all number with different bases
 *  prints to console
 *
 *  @author  Twisha Sundararajan
 *  @version Apr 7, 2019
 *  @author  Period: 5
 *  @author  Assignment: A21_1Numbers
 *
 *  @author  Sources: 
 */
public class TestNumber
{
    /**
     * 
     * main method to test number printing in console
     * @param args args passed to main
     */
    public static void main( String[] args )
    {
        int[] base = { 2, 8, 10, 16 };

        for ( int b = 0; b < base.length; b++ )
        {
            Number n = new Number( 0, base[b] );
            System.out.println( "\nbase=" + base[b] );
            for ( int i = 0; i < 256; i++ )
            {
                System.out.println( n );
                n.increment();
            }
        }
    }
}
