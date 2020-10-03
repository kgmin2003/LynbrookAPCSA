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
public class Cow implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public Cow( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Returns the sound of this Animal
     * 
     * @return A string representation of the sound this Cow makes
     */
    public String getSound()
    {
        return mySound;
    }


    /**
     * Returns the sound of this Animal
     * 
     * @return A string representation of the sound this Cow makes
     */
    public String getType()
    {
        return myType;
    }
}
