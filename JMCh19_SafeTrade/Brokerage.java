import java.lang.reflect.*;
import java.util.*;


/**
 * 
 * represents a Brokerage
 *
 * @author Twisha Sundararajan
 * @version 2019-4-1
 */
public class Brokerage implements Login
{
    private Map<String, Trader> traders;

    private Set<Trader> loggedTraders;

    private StockExchange exchange;


    /**
     * Constructs a brokerage
     * 
     * @param exchange
     */
    public Brokerage( StockExchange exchange )
    {
        this.exchange = exchange;
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
    }


    /**
     * @param string
     *            name
     * @param string
     *            password adds user to loggedTrader
     */
    public int addUser( java.lang.String name, java.lang.String password )
    {
        System.out.println( name );
        if ( name.length() < 4 || name.length() > 10 )
        {
            return -1;
        }
        else if ( password.length() < 2 || password.length() > 10 )
        {
            return -2;
        }
        else if ( name != null && traders.get( name ) != null )
        {
            return -3;
        }
        else
        {
            traders.put( name, new Trader( this, name, password ) );
            return 0;
        }
    }


    /**
     * logs in a user
     * 
     * @param name
     * @param password
     */
    public int login( java.lang.String name, java.lang.String password )
    {
        if ( !traders.containsKey( name ) )
        {
            return -1;
        }
        else if ( !( password
            .equals( traders.get( name ).getPassword() ) ) )
        {

            return -2;
        }
        else if ( loggedTraders.contains( traders.get( name ) ) )
        {
            return -3;
        }
        else
        {
            Trader logIn = traders.get( name );
            logIn.receiveMessage( "Welcome to SafeTrade!" );
            logIn.openWindow();
            loggedTraders.add( logIn );
            return 0;
        }

    }


    /**
     * 
     * logs out a trader from loggedTraders
     * 
     * @param trader
     *            trader
     */
    public void logout( Trader trader )
    {
        loggedTraders.remove( trader );
    }


    /**
     * 
     * Gets quotes from trader
     * 
     * @param symbol
     *            symbol
     * @param trader
     *            trader
     */
    public void getQuote( java.lang.String symbol, Trader trader )
    {
        trader.receiveMessage( exchange.getQuote( symbol ) );
    }


    /**
     * 
     * places order
     * 
     * @param order
     *            tradeorder
     */
    public void placeOrder( TradeOrder order )

    {
        // StockExchange places the order
        exchange.placeOrder( order ); // should call from the trader class
    }


    //
    // The following are for test purposes only
    //
    /**
     * 
     * Returns trader
     * 
     * @return traders
     */
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }


    /**
     * 
     * gets loggedTraders
     * 
     * @return loggedTraders
     */
    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }


    /**
     * 
     * gets Exchange
     * 
     * @return exchange
     */
    protected StockExchange getExchange()
    {
        return exchange;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
