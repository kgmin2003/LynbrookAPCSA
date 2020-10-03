
/**
 * Maintains a lookup table for substitutions for the letters ‘A’ through ‘Z’.
 * Initially the lookup table contains only dashes. As decryption proceeds, the
 * table is updated and gradually filled.
 * 
 * @author Twisha Sundararajan
 * @version Feb 15, 2019
 * 
 * @author Period - 5
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 */
public class Enigma
{
    private char[] lookupTable;


    /**
     * enigma constructor
     * 
     * @param numLetters
     *            number of letters
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * 
     * set the i-th element of the lookup table to ch
     * 
     * @param index
     *            index
     * @param ch
     *            character
     */
    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }


    /**
     * 
     * Decodes all the letters in text according to the current lookup table
     * 
     * @param text
     *            text to decode
     * @return String buffer
     */
    public String decode( String text )
    {

        StringBuffer buffer = new StringBuffer( text.length() );
        for ( int i = 0; i < text.length(); i++ )
        {
            char ch = text.charAt( i );
            if ( Character.isLetter( ch ) )
            {
                if ( Character.isUpperCase( ch ) )
                {
                    buffer.append( lookupTable[ch - 'A'] );
                }
                else
                {
                    ch = Character.toUpperCase( ch );
                    buffer.append(
                        Character.toLowerCase( lookupTable[ch - 'A'] ) );
                }

            }

            else
            {
                buffer.append( text.charAt( i ) );

            }
        }
        return buffer.toString();
    }


    /**
     * 
     * returns computer-generated hints for each letter in the encrypted text
     * 
     * @param text
     *            text to be generated hints for
     * @param lettersByFrequency
     *            frequency of letter
     * @return String str
     */
    public String getHints( String text, String lettersByFrequency )
    {
        int[] txtCount = countLetters( text );
        char[] freq = new char[lookupTable.length];
        for ( int j = 0; j < lookupTable.length; j++ )
        {
            int count = 0;
            for ( int i = 1; i < lookupTable.length; i++ )
            {
                if ( txtCount[i] < txtCount[count] )
                {
                    count = i;
                }
            }

            txtCount[count] = Integer.MAX_VALUE;
            freq[count] = lettersByFrequency.charAt( j );
        }
        String str = "";
        for ( char ch : freq )
        {
            str += ch;
        }
        return str;
    }


    /**
     * 
     * counts the number of occurrences for each of the letters ‘a’ through ‘z’
     * in text (case blind) and saves these 26 counts in an array
     * 
     * @param text
     *            text to check through
     * @return int of how many counts
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        for ( int i = 0; i < text.length(); i++ )
        {
            if ( Character.isLetter( text.charAt( i ) ) )
            {
                int x = Character.toUpperCase( text.charAt( i ) ) - 'A';
                counts[x]++;
            }
        }

        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * getter method for lookup Table
     * 
     * @return lookupTable
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     * 
     * getter method for count letters
     * 
     * @param text
     *            text to count letters for
     * @return countLetters for a specific text
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}