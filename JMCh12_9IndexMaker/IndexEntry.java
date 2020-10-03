import java.util.ArrayList;


/**
 * 
 *  Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Twisha Sundararajan
 * @version Nov 6, 2018
 * @author Period: 5
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: TODO
 */
public class IndexEntry
{
    // instance fields
    private String word;

    private ArrayList<Integer> numsList;


    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    /**
     * Creates new index entry given a word
     * @param word in the entry
     */
    public IndexEntry( String word )
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

    /** 
     * 
     * TODO Returns the word of this IndexEntry object.
     * @return word in the index
     */
    public String getWord()
    {
        return word;
    }

    /**
     * 
     * If num is not already in the list, adds num
     * at the end of this IndexEntry's list
     * of numbers.
     * @param num index of entry
     */
    public void add( int num )
    {
        if ( !numsList.contains( (Integer)num ) )
        {
            numsList.add( num );
        }
    }

    /**
     * 
     * Converts this IndexEntry into a string in the
     * following format: the word followed by a space, followed by
     * numbers separated by a comma and a space.
     * @return String of the word with proper spaces and commas
     */
    public String toString()
    {
        String nl = " " + numsList.get( 0 );
        for ( int i = 1; i < numsList.size(); i++ )
        {
            nl = nl + ", " + numsList.get( i );
        }

        return word + nl;
    }
}
