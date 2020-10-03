
/**
 *  Message class containing a single string. Used for testing
 *
 *  @author  Twisha Sundararajan
 *  @version Mar 2, 2019
 *  @author  Period: 5
 *  @author  Assignment: JMCh25HW
 *
 *  @author  Sources: TODO
 */
public class Message implements Comparable<Message>
{
    private String msg;
    
    public Message(String msg)
    {
        this.msg = msg;
    }

    @Override
    public int compareTo( Message other )
    {
        return msg.compareTo( other.msg );
    }
    
    public String toString()
    {
        return msg;
    }
}
