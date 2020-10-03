/**
 * Implements the minimum requirements specified by the Animal interface
 * 
 * @author Twisha Sundararajan
 * @version Oct 28, 2018
 * 
 *          Period - 5 Assignment - A29.1 - Old MacDonald
 * 
 *          Sources - Roger Frank
 */
class Chick implements Animal
{
    private String myType;

    private String mySound1;

    private String mySound2;


    /**
     * Initializes a newly created Chick object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Chick
     * @param sound1
     *            the sound the Chick makes * @param sound2 the other possible
     *            sound the Chick makes
     */
    public Chick( String type, String sound1, String sound2 )
    {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }


    /**
     * Initializes a newly created Chick object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Chick
     * @param sound1
     *            the sound the Chick makes
     */
    public Chick( String type, String sound1 )
    {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound1;
    }


    /**
     * Returns the sound of this chick
     * 
     * @return A string representation of the sound this chick makes
     */
    public String getSound()
    {
        int n = (int)( Math.random() * 2 );

        if ( n == 0 )
        {
            return mySound1;
        }
        else
        {
            return mySound2;

        }
    }


    /**
     * Returns the type of this chick
     * 
     * @return A string representation of the type of this chick
     */
    public String getType()
    {
        return myType;
    }
}