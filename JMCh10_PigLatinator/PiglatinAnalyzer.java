import java.util.Scanner;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO October 18, 2018
 * 
 * @author Period - TODO 5
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */

public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        int length = text.length();
        String translation = "";
        String word = "";

        for ( int i = 0; i < length; i++ )
        {
            char ch = text.charAt( i );

            if ( Character.isLetter( ch ) )
            {
                word += ch;

            }
            else if ( word.length() != 0 )
            {
                translation += wordToPigLatin( word ) + ch;
                word = "";
            }
            else
            {
                translation += ch;
            }

        }
        if ( word.length() != 0 )
        {
            translation += wordToPigLatin( word );
        }

        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        int start = 0;
        int vowel = 0;
        int end = englishWord.length();

        if ( vowelExists( englishWord ) )
        {
            for ( int j = 0; j < end; j++ )
            {
                char c = englishWord.charAt( j );
                if ( isVowel( c ) )
                {
                    vowel = j;
                    break;
                }

            }
            if ( start == vowel )
            {
                pigLatinWord = englishWord.substring( vowel, end ) + "yay";
                if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                {

                    String startString = englishWord.substring( vowel,
                        end );
                    String endString = englishWord.substring( start,
                        vowel ) + "yay";
                    String starter = startString.substring( 0, 1 );
                    startString = startString.substring( 1 );
                    pigLatinWord = starter.toUpperCase()
                        + startString.toLowerCase()
                        + endString.toLowerCase();
                }
            }
            else if ( start != vowel )
            {
                String startString = englishWord.substring( vowel, end );
                String endString = englishWord.substring( start, vowel );
                pigLatinWord = startString + endString + "ay";
                if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                {
                    String starter = startString.substring( 0, 1 );
                    startString = startString.substring( 1 );
                    pigLatinWord = starter.toUpperCase()
                        + startString.toLowerCase()
                        + endString.toLowerCase() + "ay";
                }
            }

        }
        else
        /* if no vowel */
        {

            pigLatinWord = englishWord + "ay";
            if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
            {

                String startString = englishWord.substring( vowel, end );
                String endString = englishWord.substring( start, vowel )
                    + "ay";
                String starter = startString.substring( 0, 1 );
                startString = startString.substring( 1 );
                pigLatinWord = starter.toUpperCase()
                    + startString.toLowerCase() + endString.toLowerCase();
            }

        }

        return pigLatinWord;
    }


    /**
     * Check whether vowel exists
     *
     * @param String
     *            s a string representing an english word
     * @return boolean
     */
    public boolean vowelExists( String s )
    {
        int wordEnd = s.length();

        for ( int j = 0; j < wordEnd; j++ )
        {
            char c = s.charAt( j );
            if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U' )
            {
                return true;
            }
        }
        return false;

    }


    /**
     * Checks whether char is vowel
     *
     * @param c
     *            a letter of the alphabet
     * @return boolean
     */
    public boolean isVowel( char c )
    {
        if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' )
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    /**
     * Checks whether char is punctuation
     *
     * @param c
     *            punctuation
     * @return boolean
     */
    public boolean isPunc( char c )
    {
        if ( c == ';' || c == '-' || c == ',' || c == '.' || c == '?'
            || c == '!' || c == ':' || c == '\"' || c == '\'' )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

