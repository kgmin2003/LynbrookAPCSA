import java.lang.reflect.*;
import java.util.*;


/**
 * 
 * Represents a stock trader.
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName, password;

    private TraderWindow myWindow;

    private Queue<String> mailbox;


    Trader( Brokerage brokerage1, String name1, String pswd1 )
    {
        brokerage = brokerage1;
        screenName = name1;
        password = pswd1;
        mailbox = new LinkedList<String>();

    }


    public int compareTo( Trader other )
    {
        return screenName.compareToIgnoreCase( other.screenName );
    }


    public boolean equals( Trader other )
    {
        return screenName.equalsIgnoreCase( other.screenName );
    }


    public String getName()
    {
        return screenName;
    }


    public String getPassword()
    {
        return password;
    }


    public void getQuote( String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    public boolean hasMessages()
    {
        return !mailbox.isEmpty();
    }


    public void openWindow()
    {
        myWindow = new TraderWindow( this );
        for ( String q : mailbox )
        {
            myWindow.showMessage( q );
        }
    }


    public void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    public void quit()
    {
        brokerage.logout( this );
        myWindow = null;
    }


    public void receiveMessage( String msg )
    {
        if ( msg == null )
        {
            return;
        }

        mailbox.add( msg );
        if ( myWindow != null )
        {
            for ( String q : mailbox )
            {
                myWindow.showMessage( q );
            }
        }
    }


    //
    // The following are for test purposes only
    //
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                else
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
