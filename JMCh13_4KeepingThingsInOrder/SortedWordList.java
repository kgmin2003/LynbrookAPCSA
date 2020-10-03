/**
 * Implements a sorted list of words
 * 
 * @author Twisha Sundararajan
 * @version Nov 28, 2018
 * 
 * @author Period - 5
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - TODO list collaborators
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * no args constructor
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * constructor with argument
     * 
     * @param capacity
     *            the initial capacity of the list
     */
    public SortedWordList( int capacity )
    {
        super( capacity );
    }


    /**
     * 
     * returns the index within this string of the first occurrence of the
     * specified character or -1, if the character does not occur.
     * 
     * @param str string to be searched for
     * @return int index
     */
    public int indexOf( String str )
    {
        int l = 0;
        int g = this.size() - 1;
        int avgIndex;
        while ( l <= g )
        {
            avgIndex = ( l + g ) / 2;
            int compare = str.compareToIgnoreCase( this.get( avgIndex ) );
            if ( compare > 0 )
            {
                l = avgIndex + 1;
            }
            else if ( compare < 0 )
            {
                g = avgIndex - 1;
            }
            else if ( compare == 0 )
            {
                return avgIndex;
            }
        }
        return -1;
    }


    /**
     * 
     * Checking the specified element existence in the given list. returns true
     * if the specified element is found in the list else it gives false.
     * 
     * @param str string to be searched for
     * @return boolean value
     */
    public boolean contains( String str )
    {
        boolean contain = true;
        if ( indexOf( str ) == -1 )
        {
            contain = false;
        }
        return contain;
    }


    /**
     * 
     * @param i initial index
     * @param word to be added
     * @return string
     */
    public String set( int i, String word )
    {
        String str;
        int right = word.compareToIgnoreCase( this.get( i + 1 ) );

        if ( i == 0 && right < 0 )
        {
            str = super.set( i, word );
        }
        else if ( word.compareToIgnoreCase( this.get( i - 1 ) ) > 0
            && right < 0 )
        {
            str = super.set( i, word );
        }
        else if ( i == this.size() - 1
            && word.compareToIgnoreCase( this.get( i - 1 ) ) > 0 )
        {
            str = super.set( i, word );
        }
        else
        {
            throw new IllegalArgumentException(
                "word = " + word + " i = " + i );
        }
        return str;

    }


    /**
     * checks if word fits alphabetically in the index provided
     * 
     * @param i initial index
     * @param word to be added
     */
    public void add( int i, String word )
    {
        if ( i == 0 && word.compareToIgnoreCase( this.get( i + 1 ) ) > 0 )
        {
            throw new IllegalArgumentException(
                "word =" + word + " i =" + i );
        }
        else if ( i > this.size() )
        {
            throw new IllegalArgumentException(
                "word =" + word + " i =" + i );
        }
        else if ( i == 0 && word.compareTo( this.get( i + 1 ) ) < 0 )
        {
            super.add( i, word );
        }
        else if ( i == this.size()
            && word.compareTo( this.get( i - 1 ) ) > 0 )
        {
            super.add( i, word );
        }
        else if ( word.compareTo( this.get( i - 1 ) ) > 0
            && word.compareTo( this.get( i + 1 ) ) < 0 )
        {
            super.add( i, word );
        }
        else
        {
            throw new IllegalArgumentException(
                "word =" + word + " i =" + i );
        }

    }

    /**
     * Checking the specified element existence in the given list. returns true
     * if the specified element can be added to the list else it gives false.
     * 
     * @param a string to be checked for
     * @return boolean value
     */
    public boolean add( String a )
    {
        if ( this.contains( a ) ) {
            return false;
        }

        int left = 0;
        int right = this.size() - 1;
        int average;
        while ( left <= right )
        {

            average = ( left + right ) / 2;

            int subtract = a.compareTo( this.get( average ) );
            if ( subtract > 0 )
            {
                left = average + 1;
            }
            else if ( subtract < 0 )
            {
                right = average - 1;
            }
        }
        super.add( right + 1, a );
        return true;

    }
    /**
     * 
     *  insert into this list in alphabetical order all the words from 
     *  additionalWords that are not already in this list
     * @param additionalWords new list
     */
    public void merge( SortedWordList additionalWords )
    {
        for ( String x : additionalWords )
        {
            add( x );
        }
    }

}
