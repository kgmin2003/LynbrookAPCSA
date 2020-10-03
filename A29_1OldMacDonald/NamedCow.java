/**
 * Extends Cow class
 * 
 * @author Twisha Sundararajan
 * @version Oct 28, 2018
 * 
 *          Period - 5 Assignment - A29.1 - Old MacDonald
 * 
 *          Sources - Roger Frank
 */
class NamedCow extends Cow
{
    private String myName;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound and given name.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );

    }

    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound and given name.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     * @param name
     *            the name of the Cow
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        myName = name;
    }

    /**
     * Returns the name of this pig
     * 
     * @return A string representation of the name of this pig
     */
    public String getName()
    {
        return myName;
    }

}
