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
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Initializes a newly created Pig object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Pig
     * @param sound
     *            the sound the pig makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Returns the sound of this pig
     * 
     * @return A string representation of the sound this pig makes
     */
    public String getSound()
    {
        return mySound;
    }


    /**
     * Returns the type of this pig
     * 
     * @return A string representation of the type of this pig
     */
    public String getType()
    {
        return myType;
    }
}