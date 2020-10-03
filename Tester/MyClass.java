
public class MyClass
{
    public static double max( double[] v, int n )
    {
        double m = v[n - 1];
        double m2;
        if ( n > 1 )
        {
            System.out.println( "in if statement" );
            m2 = max( v , n - 1) ;
            if ( m2 > m ) 
            {
                m = m2;
                System.out.println( m );
            }

        }
        return m;
    }



    public static void main(String args[]) 
        {
            double[] v = new double [] {1.0, 4.0, 2.0, 5.0, 3.0};
            max(v , 5);
        }
}
