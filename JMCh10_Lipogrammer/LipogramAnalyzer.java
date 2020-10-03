/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO 10/8/18
 * 
 * @author Period - TODO 5
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - TODO list collaborators
 */
public class LipogramAnalyzer
{
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        int length = text.length();
        String s1 = "";
        for ( int i = 0; i <= length - 1; i++ )
        {
            char ch = text.charAt( i );
            if ( ch == letter )
            {

                s1 += "#";

            }
            else
            {
                s1 += ch;

            }

        }
        return s1;
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {

        String concatenatedString = "";
        String wordWithChar = "";
        int length = text.length();

        for ( int i = 0; i < length; i++ )
        {
            int pos = text.indexOf( letter, i );

            wordWithChar = this.extractWord( pos );

            System.out.println( "wordWithChar = " + wordWithChar );

            if ( wordWithChar.equals( "e" ) )
            {
                concatenatedString += wordWithChar + '\n';

            }
            else if ( concatenatedString.indexOf( wordWithChar ) == -1 )
            {

                concatenatedString += wordWithChar + '\n';

            }

            i = text.indexOf( " ", pos );

            if ( i < 0 )
            {
                break;
            }

        }

        return concatenatedString;
    }


    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        int nextSpace = text.indexOf( " ", pos );

        int firstSpace = text.lastIndexOf( " ", pos );
        if ( nextSpace < 0 )
        {
            nextSpace = this.text.length();
        }
        String word = text.substring( firstSpace + 1, nextSpace );

        for ( int i = 0; i < word.length(); i++ )
        {
            char ch = word.charAt( i );

            if ( !Character.isLetter( ch ) )
            {
                word = word.replace( ch, '\n' );
            }
        }

        return word.trim();
    }

}
