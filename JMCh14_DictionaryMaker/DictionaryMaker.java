import java.util.Scanner;
import java.io.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Twisha Sundararajan
 * @version Nov 19, 2018
 * 
 * @author Period - 5
 * @author Assignment - JM Ch14 - DictionaryMaker
 * 
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;

    public static Scanner fileIn; // public for test purposes

    public static PrintWriter fileOut; // public for test purposes


    public static void main( String[] args ) throws IOException
    {
        Scanner kboard = new Scanner( System.in );

        System.out.println();
        System.out.print( "Enter input file name: " );
        String fileName = kboard.next();

        openInputFile( fileName );
        if ( fileIn == null )
        {
            System.out.println( "*** Can't open " + fileName + " ***" );
            return;
        }

        createOutputFile( "RamblecsDictionary.java" );
        if ( fileOut == null )
        {
            fileIn.close();
            System.out
                .println( "*** Can't create RamblecsDictionary.java ***" );
            return;
        }

        int count = copyWords();
        System.out.println( "Done: " + count + " words." );

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     */
    public static void openInputFile( String fileName )
    {
        try
        {
            fileIn = new Scanner( new FileReader( fileName ) );
        }
        catch ( FileNotFoundException e )
        {
            return;
        }
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     */
    public static void createOutputFile( String fileName )
    {
        try
        {
            fileOut = new PrintWriter( new FileWriter( fileName ) );
        }
        catch ( IOException e )
        {
            return;
        }
    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {
        int x = 0;
        fileOut.println(
            "public class RamblecsDictionary\n{\n\tpublic String words[] = \n\t{" );
        while ( fileIn.hasNext() )
        {
            String a = fileIn.next().toUpperCase();
            if ( a.length() >= MINLENGTH && a.length() <= MAXLENGTH )
            {
                fileOut.println( "\t\t\"" + a + "\"," );
                x++;
            }
        }
        fileOut.println( "\t};\n}" );
        fileOut.close();

        return x;
    }
}
