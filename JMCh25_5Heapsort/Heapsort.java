/**
 * Apply sorting algorithm to an array, without creating a separate priority
 * queue
 * 
 * @author Twisha Sundararajan
 * @version March 10
 * 
 * @author Period: 5
 * @author Assignment - Heap Sort
 * 
 * @author Sources - list collaborators
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    public static void sort( double[] a )
    {
        int length = a.length;
        for ( int i = length / 2; i >= 1; i-- )
        {
            reheapDown( a, i, length );
        }
        while ( length > 1 )
        {
            double temp = a[0];
            a[0] = a[length - 1];
            a[length - 1] = temp;
            length--;
            reheapDown( a, 1, length );
        }
    }


    // Should be private - made public for testing
    public static void reheapDown( double[] a, int i, int n )
    {
        int curr = i - 1;
        while ( 2 * curr + 1 < n )
        {
            if ( 2 * curr + 2 == n )
                if ( a[curr] > a[2 * curr + 1] )
                {
                    return;
                }
                else
                {
                    double temp = a[curr];
                    a[curr] = a[2 * curr + 1];
                    a[2 * curr + 1] = temp;
                    return;
                }
            if ( a[curr] >= a[2 * curr + 1] && a[curr] >= a[2 * curr + 2] )
            {
                return;
            }
            if ( a[2 * curr + 1] > a[2 * curr + 2] )
            {
                double t = a[curr];
                a[curr] = a[2 * curr + 1];
                a[2 * curr + 1] = t;
                curr = 2 * curr + 1;
            }
            else
            {
                double t = a[curr];
                a[curr] = a[2 * curr + 2];
                a[2 * curr + 2] = t;
                curr = 2 * curr + 2;
            }
        }
    }
}
