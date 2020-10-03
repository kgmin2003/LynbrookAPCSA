//Twisha 
import java.lang.reflect.*;
import java.util.*;

/**
 * Represents a stock exchange. A <code>StockExchange</code> keeps a
 * <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 * list a new stock, request a quote for a given stock symbol, and to place a
 * specified trade order.
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;


    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }


    public void listStock( java.lang.String symbol, java.lang.String name,
        double price )
    {
        Stock stck = new Stock (symbol, name, price);
        listedStocks.put( symbol, stck );
    }
    
    public java.lang.String getQuote(java.lang.String symbol) 
    {
        return listedStocks.get( symbol ).getQuote();
    }
    
    public void placeOrder(TradeOrder order) 
    {
        if (order == null) {
            return;
        }
        
        Stock order1 = listedStocks.get( order.getSymbol() );
        if (order1==null) {
            String message = order.getSymbol() + " not found";
            order.getTrader().receiveMessage( message );
            return;
        }
        
        order1.placeOrder(order);
        
        
    }


    //
    // The following are for test purposes only
    //
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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




