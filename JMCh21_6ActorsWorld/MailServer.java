import java.util.*;

/**
 *  A mechanism for queuing and dispatching messages.
 *  A queue of messages that has a method to dispatch 
 *  a message to the appropriate recipient.
 *  
 *  Also keeps a set of all “registered” subscribers. 
 *  
 * @author Twisha Sundararajan
 * @version January 22, 2019
 * 
 * @author Period - 5
 * @author Assignment - Actors World
 * 
 * @author Sources -  list collaborators
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    /**
     * constructs a MailServer
     */
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }    
    
    /**
     * 
     * adds actor into the set of registered subscribers
     * @param actor to get added to set
     */
    public void signUp( Actor actor ) 
    {
        actors.add( actor );
    }
    
    /**
     * 
     * Sends msg to the recipient indicated or if recipient is null, 
     * sends to all registered subscribers (except sender)
     * @param msg msg to be sent
     */
    public void dispatch( Message msg )
    {
        if (msg.getRecipient() == null) 
        {
            for (Actor actor : actors)
            {
                actor.receive( msg );
            }
        } 
        else
        {
            msg.getRecipient().receive( msg );
        }
    }

    
    
    // for testing purposes only
    /**
     * 
     * gets actors
     * @return actors actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
