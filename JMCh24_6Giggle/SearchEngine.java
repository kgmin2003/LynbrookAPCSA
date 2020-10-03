import java.util.*;


/**
 * Builds the index for a file and generates the search results Uses a map
 * object to hold the word index
 * 
 * @author Twisha Sundararajan
 * @version February 22, 2019
 * 
 * @author Period - 5
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - list collaborators
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    // Constructor(s)
    /**
     * SearchEngine constructor
     * 
     * @param url
     *            string of url
     */
    public SearchEngine( String url )
    {
        myURL = url;
        myIndex = new HashMap( 20000 );
    }


    // Methods
    /**
     * Getter method for myURL
     * 
     * @return string myURL
     */
    public String getURL()
    {
        return myURL;
    }


    /**
     * Add words to map
     * 
     * @param line
     *            string of text
     */
    public void add( String line )
    {
        Set<String> lineTree = parseWords( line );

        for ( String str : lineTree )
        {

            List<String> listLine = new LinkedList<String>();
            if ( !myIndex.containsKey( str ) )
            {
                myIndex.put( str, listLine );
            }
            myIndex.get( str ).add( line );

        }
    }


    /**
     * Returns the list of lines associated with word in myIndex.
     * 
     * @param word
     *            to search how many hits it has
     * @return List<String>
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );
    }


    /**
     * Returns a set of all words in line
     * 
     * @param line
     *            string of words
     * @return set of words
     */
    private Set<String> parseWords( String line )
    {
        TreeSet<String> wordTree = new TreeSet<String>();

        String[] words = line.split( "\\W+" );

        for ( String str : words )
        {
            if ( str.length() != 0 )
            {
                str = str.toLowerCase();
                wordTree.add( str );
            }
        }
        return wordTree;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * getter method for index
     * 
     * @return myIndex gets index
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
