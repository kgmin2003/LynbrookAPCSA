
public class power
{
    // precondition: n >= 0
    public static int power3( int n )
    {
        if ( n == 0 ) // if n equals to 0
            return 1;
        else
        {
            int p = power3( n / 2 );

            System.out.println( p );
          
            p *= p;
            
            if ( n % 2 == 1 ) // if n is odd 
            {
                p *= 3; // multiply p by 3
                System.out.println( "m" );
            }
            return p;
        }
    }


    public static void main( String args[] )
    {
        System.out.println( power3(15) );
       
    }
}
