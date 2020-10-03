
import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 */
public class Stock
{
    public static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice, hiPrice, lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders, sellOrders;


    public Stock( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;
        lastPrice = price;
        loPrice = price;
        hiPrice = price;
        volume = 0;
        buyOrders = new PriorityQueue<TradeOrder>( 11,
            new PriceComparator() );
        sellOrders = new PriorityQueue<TradeOrder>( 11,
            new PriceComparator() );
    }


    public String getQuote()
    {

        String quote = companyName + " (" + stockSymbol + ")\n" + "Price: "
            + lastPrice + " hi: " + hiPrice + " lo: " + loPrice + " vol: "
            + volume + "\n" + "Ask: ";
        if ( buyOrders.isEmpty() )
        {
            quote += "none ";
        }
        else
        {
            quote += buyOrders.peek().getPrice() + " size: "
                + buyOrders.peek().getShares() + " ";
        }

        if ( sellOrders.isEmpty() )
        {
            quote += "Bid: none";
        }
        else
        {
            quote += "Bid: " + sellOrders.peek().getPrice() + " size: "
                + sellOrders.peek().getShares();
        }

        return quote;
    }


    public void placeOrder( TradeOrder order )
    {

        if ( !order.getSymbol().equals( stockSymbol ) )
        {
            System.out.println( "" );
            System.out.println( "not found " + order.getSymbol() );
            return;
        }
        String message = "New order: ";

        // if its a buy order, add the order to the buyOrder queue
        if ( order.isBuy() )
        {
            buyOrders.add( order );
            message += "Buy ";
        }
        else // if its a sell order, add it to the sell order queue
        {
            sellOrders.add( order );
            message += "Sell ";
        }

        // send the respective message to the trader
        message += stockSymbol + " " + companyName + "\n";
        message += order.getShares() + " shares at $" + order.getPrice();

        order.getTrader().receiveMessage( message );
        executeOrders();
    }


    protected void executeOrders()
    {
        int shares;
        double price = 0;
        while ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            // Giving names so I don't have to type it out
            TradeOrder BO = buyOrders.peek();
            TradeOrder SO = sellOrders.peek();

            // determines which one has the lesser amount of shares
            if ( BO.getShares() > SO.getShares() )
            {
                shares = SO.getShares();
            }
            else
            {
                shares = BO.getShares();
            }

            // if both are limit orders and the buy order price is more than
            // the sell order price
            if ( BO.isLimit() && SO.isLimit()
                && BO.getPrice() >= SO.getPrice() )
            {

                BO.subtractShares( shares );
                SO.subtractShares( shares );
                price = SO.getPrice();
            }

            // Buy order is a limit order, Sell order is a market order
            else if ( BO.isLimit() && SO.isMarket() )
            {

                BO.subtractShares( shares );
                SO.subtractShares( shares );
                price = BO.getPrice();

            }

            // Sell Order is a limit order, buy order is a market order
            else if ( SO.isLimit() && BO.isMarket() )
            {

                BO.subtractShares( shares );
                SO.subtractShares( shares );
                price = SO.getPrice();

            }
            // both are market orders
            else if ( BO.isMarket() && SO.isMarket() )
            {

                BO.subtractShares( shares );
                SO.subtractShares( shares );
                price = lastPrice;
            }

            // removes the buy/sell order from the queue if they are finished
            // ie the number of shares to be traded is 0
            if ( BO.getShares() == 0 )
            {
                buyOrders.remove();
            }
            if ( SO.getShares() == 0 )
            {
                sellOrders.remove();
            }

            // adjusts the hiPrice, loPrice, volume, and lastPrice
            if ( price > hiPrice )
            {
                hiPrice = price;
            }
            if ( price < loPrice )
            {
                loPrice = price;
            }
            lastPrice = price;
            volume += shares;

            // sends a message to the buyer/seller telling them what they
            // bought/sold
            String message = "You bought: " + shares + " " + stockSymbol
                + " at" + price + " amt " + shares * price;

            String message1 = "You sold: " + shares + " " + stockSymbol
                + " at " + price + " amt " + shares * price;

            BO.getTrader().receiveMessage( message );
            SO.getTrader().receiveMessage( message1 );
        }
    }


    //
    // The following are for test purposes only
    //

    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    protected String getCompanyName()
    {
        return companyName;
    }


    protected double getLoPrice()
    {
        return loPrice;
    }


    protected double getHiPrice()
    {
        return hiPrice;
    }


    protected double getLastPrice()
    {
        return lastPrice;
    }


    protected int getVolume()
    {
        return volume;
    }


    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
