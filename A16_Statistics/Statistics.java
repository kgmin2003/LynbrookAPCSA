import java.util.Scanner;
import java.io.*;


/**
 * A class for calculating Statistics on a set of numbers.
 *
 * @author TODO Twisha Sundararajan
 * @version TODO Oct 29,2018
 * @author Period: TODO 5
 * 
 * @author Assignment: Lab Activity 16.1 - Statistics
 * 
 * @author Sources: TODO: list collaborators
 */
public class Statistics
{
    private final static int MAX_VALUE = 100;

    private int[] statsData = new int[1000];

    private int howMany;


    /**
     * Constructs this object with an array of integers for use with statistical
     * calculation
     * 
     * @param fileName
     *            name of file containing numbers for statistical evaluation
     */
    public Statistics( String fileName )
    {
        howMany = 0;
        loadFile( fileName );
    }


    /**
     * Loads text file into array data. Values are stored from positions
     * 0..howMany-1. Returns the number of data values as howMany
     * 
     * @param fileName
     *            file or string containing numbers to read
     */
    public void loadFile( String fileName )
    {
        int index = 0;
        Scanner inFile;

        try
        {
            if ( new File( fileName ).isFile() )
            {
                inFile = new Scanner( new File( fileName ) );
            }
            else
            {
                inFile = new Scanner( fileName );
            }

            while ( inFile.hasNext() )
            {
                statsData[index] = inFile.nextInt();
                index++;
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
        howMany = index;
    }


    /**
     * Returns average of values in vector data.
     * 
     * @return average of this objects data collection
     */
    public double average()
    {
        long sum = 0;
        for ( int i = 0; i < howMany; i++ )
        {
            int temp = statsData[i];
            sum += temp;
        }
        // System.out.println( howMany + " " +sum );
        double avg = (double)sum / (double)( howMany );
        return avg;
    }


    /**
     * Finds standard deviation of values in vector data.
     * 
     * @return the standard deviation of the vector data
     */
    public double stdDev()
    {
        long sum = 0;
        double avg = this.average();

        for ( int i = 0; i < howMany; i++ )
        {
            double diff = statsData[i] - avg;
            diff *= diff;
            sum += diff;
        }
        double sqrt = (double)sum / ( howMany - 1 );

        return Math.sqrt( sqrt );
    }


    /**
     * finds the largest integer in the array scores. This array is sized from
     * 0..MAX_VALUE, with each element storing the quantity of each number from
     * 0..MAX_VALUE.
     * 
     * @return largest integer in the array scores
     * @param scores
     *            integer array sized at MAX_VALUE+1 with each element storing
     *            the quantity of each number from 0..MAX_VALUE
     */
    public int findLargest( int[] scores )
    {
        int largeNum = 0;
        for ( int i = 0; i < MAX_VALUE; i++ )
        {
            int temp = scores[i];
            if ( temp > largeNum )
            {
                largeNum = temp;
            }
        }
        return largeNum;
    }


    /**
     * The array data is analyzed and transferred into a smaller array smallList
     * (0..MAX_VALUE). For each occurrence of n in the array data, smallList[n]
     * is incremented +1. findLargest is then called to find the largest
     * quantity in the array smallList. The mode(s) is/are returned in an array.
     * 
     * @return array of mode(s)
     */
    public int[] findMode()
    {
        // creation of smallList
        int[] smallList = new int[MAX_VALUE + 1];
        for ( int i = 0; i < howMany; i++ )
        {
            if ( statsData[i] != 0 )
            {
                smallList[statsData[i]] += 1;
            }
        }
        // count of largest numbers present in smallList
        int num = findLargest( smallList );
        int count = 0;
        for ( int n = 0; n < smallList.length; n++ )
        {
            if ( smallList[n] == num )
            {
                count++;
            }
        }
        // which numbers from original array is/are the mode(s)
        int inc = 0;
        int[] mode = new int[count];
        for ( int n = 0; n < smallList.length; n++ )
        {
            if ( smallList[n] == num && inc < count )
            {
                mode[inc] = n;
                inc++;
            }
        }
        return mode;
    }


    public static void main( String[] args )
    {
        Statistics fileStats = new Statistics( "numbers.txt" );

        System.out.printf( "The average = %6.2f", fileStats.average() );
        System.out.println();
        System.out.printf( "Standard deviation = %6.2f",
            fileStats.stdDev() );
        System.out.println();

        int[] mode = fileStats.findMode();
        System.out.print( "The mode is(are) --> " );
        for ( int m : mode )
        {
            System.out.print( m + "  " );
        }
    }
}
