import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Twisha Sundararajan, Rithwik Kerukur, Doris Wei
 * @version April 1
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: TODO sources
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;
    
    private StockExchange exchange = new StockExchange();

    private Brokerage br = new Brokerage( exchange );

    private String name = "Kyle";

    private String password = "mypass";

    private Set<String> loggedTraders;

    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>", to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be " + symbol + " >>",
            symbol,
            to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder + " >>", to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder + " >>",
            to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder + " >>",
            to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder + ">>",
            to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be " + numShares + ">>",
            numShares == to.getShares() || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price + ">>",
            price,
            to.getPrice(),
            0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        to.subtractShares( numToSubtract );
        assertEquals( "<< TradeOrder: subtractShares(" + numToSubtract + ") should be "
            + ( numShares - numToSubtract ) + ">>", numShares - numToSubtract, to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }

    @Test
    public void seConstructor()
    {
        String test = exchange.toString();
        assertTrue("<<StockExchange: StockExchange() >>",
            test.equals( "StockExchange[java.util.Map listedStocks:{}]" ));
    }


    @Test
    public void seListStock()
    {
        exchange.listStock(symbol, name, 10.0 );
        assertTrue("<<StockExchange: listStock() >>", 
            exchange.getListedStocks().containsKey( symbol ));
    }


    @Test
    public void seGetQuote()
    {
        Stock stk = new Stock(symbol, name, 3.0);
        exchange.getListedStocks().put( symbol, stk );
        String message = "Kyle (GGGL)\nPrice: 3.0 hi: 3.0 lo: 3.0"
                        + " vol: 0\nAsk: none Bid: none";
        System.out.println(exchange.getQuote(symbol));
        System.out.println(message);
        assertEquals("<<StockExchange: getQuote() >>", 
            "Kyle (GGGL)\nPrice: 3.0 hi: 3.0 lo: 3.0"
            + " vol: 0\nAsk: none Bid: none", exchange.getQuote(symbol));
    }


    @Test
    public void sePlaceOrder()
    {
        // name - kyle
        
        Trader trader = new Trader(br, name, password);
        TradeOrder to = new TradeOrder(trader, symbol, true, true, 5,
                10.0);

        Stock stk = new Stock(symbol, name, 3.0);
        exchange.getListedStocks().put( name, stk);
        exchange.placeOrder(to);

        assertTrue("<<StockExchange: placeOrder()>>",
                trader.hasMessages());
    }

@Test
    public void pcConstructor1()
    {
        PriceComparator pc = new PriceComparator();
        assertNotNull(pc);
    }

    @Test
    public void pcConstructor2()
    {
        PriceComparator pc= new PriceComparator(false);
        assertNotNull(pc);                       
    }

    @Test
    public void pcMarketMarket()
    {
        TradeOrder order1 = new TradeOrder(null, symbol, buyOrder, marketOrder, numShares, 111.11);
        TradeOrder order2 = new TradeOrder(null, symbol, buyOrder, marketOrder, numShares, 100);
        PriceComparator pc= new PriceComparator(false);
        
        // Asserts that both orders are market orders
        assertEquals(pc.compare( order1, order2 ), 0);
    }
    
    @Test
    //order1 is market and order2 is limit
    public void pcCompareMarketLimit()
    {
        TradeOrder order1 = new TradeOrder(null, symbol, buyOrder, marketOrder, numShares, 111.11);
        TradeOrder order2 = new TradeOrder(null, symbol, buyOrder, !marketOrder, numShares, 100);
        PriceComparator pc= new PriceComparator(false);
        
        assertEquals(pc.compare( order1, order2 ), -1);
    }

    @Test
    //order1 is limit and order 2 is market
    public void pcCompareLimitMarket()
    {
        TradeOrder order1 = new TradeOrder(null, symbol, buyOrder, !marketOrder, numShares, 111.11);
        TradeOrder order2 = new TradeOrder(null, symbol, buyOrder, marketOrder, numShares, 100);
        PriceComparator pc= new PriceComparator(false);
        
        assertEquals(pc.compare( order1, order2 ), 1);
    }
    
    @Test
    public void pcCompareAscending()
    {
        double cents1 = 111;
        double cents2 = 100;
        boolean ascending = true;
        TradeOrder order1 = new TradeOrder(null, symbol, buyOrder, !marketOrder, numShares, cents1);
        TradeOrder order2 = new TradeOrder(null, symbol, buyOrder, !marketOrder, numShares, cents2);
        PriceComparator pc= new PriceComparator(ascending);

        assertEquals((long) (pc.compare(order1, order2)), 11);
    }
    
    @Test
    public void pcCompareDescending()
    {
        double cents1 = 111.0;
        double cents2 = 100.0;
        boolean ascending = false;
        TradeOrder order1 = new TradeOrder(null, symbol, buyOrder, !marketOrder, numShares, cents1);
        TradeOrder order2 = new TradeOrder(null, symbol, buyOrder, !marketOrder, numShares, cents2);
        PriceComparator pc= new PriceComparator(ascending);

        assertEquals((long) (pc.compare(order1, order2)), -11);
    }
    

    public void pctoString()
    {
        PriceComparator pc = new PriceComparator();
        assertNotNull( pc.toString() );
    }


    // --Test Trader
    @Test
    public void traderCompareTo()
    {
        Trader one = new Trader( null, "one", "pass" );
        Trader two = new Trader( null, "two", "Pass" );

        assertTrue( one.compareTo( two ) < 0 );

    }


    @Test
    public void traderEquals()
    {
        Trader one = new Trader( null, "one", "pass" );
        Trader two = new Trader( null, "one" + "", "Pass" );
        assertTrue( one.equals( two ) );

    }


    @Test
    public void traderGetName()
    {
        Trader one = new Trader( null, "one", "pass" );
        assertEquals( one.getName(), "one" );
    }


    @Test
    public void traderGetpassword()
    {
        Trader one = new Trader( null, "one", "pass" );
        assertEquals( one.getPassword(), "pass" );
    }


    @Test
    public void traderhasMessages()
    {
        Trader one = new Trader( null, "one", "pass" );
        one.receiveMessage( "test" );
        assertTrue( one.hasMessages() );
    }


    @Test
    public void traderReceiveMessage()
    {
        Trader one = new Trader( null, "one", "pass" );
        one.receiveMessage( "test" );
        assertEquals( one.mailbox().peek().toString(), "test" );
    }


    @Test
    public void TradertoString()
    {
        Trader one = new Trader( null, "one", "pass" );
        assertNotNull( one.toString() );
    }

    


    @Test
    public void brokerageConstructor()
    {
        String toStr = br.toString();
        assertTrue( "<< Invalid Brokerage Constructor >>",
            toStr.contains( "Brokerage[java.util.Map traders:{}, "
                + "java.util.Set loggedTraders:[], "
                + "StockExchange exchange:StockExchange"
                + "[java.util.Map listedStocks:{}]]" ) );
    }


    @Test
    public void brokerageAddUser()
    {
        br.addUser( name, password );
        String test = br.toString();
        assertEquals( "<< Brokerage: addUser() >>",
            test.contains( "mypass" ),
            true );
        assertEquals( "<< Brokerage: addUser() >>",
            test.contains( "Kyle" ),
            true );
    }


    @Test
    public void brokerageLogin()
    {
        br.addUser( name, password );
        // wrong name
        
        assertEquals( "<<Brokerage: login() >>",
            -1,
            br.login( "John", "mypass" ) );
        // right name wrong pass
        
        assertEquals( "<<Brokerage: login() >>",
            -2,
            br.login( "Kyle", "wrongPass" ) );
        // worked
        
        assertEquals( "<<Brokerage: login() >>",
            0,
            br.login( "Kyle", "mypass" ) );
        // already logged in
        br.login( name, password );
        assertEquals( "<<Brokerage: login() >>",
            -3,
            br.login( "Kyle", "mypass" ) );
    }


    @Test
    public void brokerageLogout()
    {
        br.addUser( name, password );
        br.login( name, password );
        Trader trader = new Trader( br, name, password );
        br.logout( trader );
        assertFalse( "<<Brokerage: logout() >>",
            br.getLoggedTraders().contains( trader ) );
    }


    @Test
    public void brokerageGetQuote()
    {
        exchange = new StockExchange();
        exchange.listStock( symbol, name, 1.0 );
        br = new Brokerage( exchange );
        Trader trader = new Trader( br, name, password );
        
        br.getQuote( symbol, trader );
        assertTrue("<<Brokerage: getQuote() >>" , trader.hasMessages());
    }


    @Test
    public void brokeragePlaceOrder()
    {
        exchange.listStock( symbol, name, 1.00 );

        Trader trader = new Trader(br, symbol, password);
        
        TradeOrder to = new TradeOrder(trader, symbol, true, false, 1, 2.0);

//        Stock stk = new Stock(symbol, name, 3.0);
//       
//        exchange.getListedStocks().put(symbol, stk);

        br.placeOrder(to);

        assertTrue("<<Brokerage: placeOrder() >>",
                trader.hasMessages());
    }
    

    

    // --Test Stock
    @Test
    public void stockGetQuoteNoOrders() {
        Stock one = new Stock("CS", "Computer", 5.00);
        
        String result =  "Computer (CS)\nPrice: 5.0 hi: 5.0 lo: 5.0 vol: 0\nAsk: none Bid: none";
        
        assertEquals(one.getQuote(), result );
    }
    @Test
    public void stockGetQuoteBuyOrder() {
        Stock one = new Stock("CS", "Computer", 5.00);
        Trader trader = new Trader(null, "one", "pass");
        TradeOrder order = new TradeOrder(trader, "CS", true, false, 10, 6.0);
        
        one.placeOrder( order );
        
        String result =  "Computer (CS)\nPrice: 5.0 hi: 5.0 lo: 5.0 vol: 0\nAsk: 6.0 size: 10 Bid: none";
        
        assertEquals(one.getQuote(), result);
    }
    @Test
    public void stockGetQuoteSellOrder() {
        Stock one = new Stock("CS", "Computer", 5.00);
        Trader trader = new Trader(null, "one", "pass");
        TradeOrder order = new TradeOrder(trader, "CS", false, true, 10, 6.0);
        
        one.placeOrder( order );
        
        String result =  "Computer (CS)\nPrice: 5.0 hi: 5.0 lo: 5.0 vol: 0\nAsk: none Bid: 6.0 size: 10";
        
        assertEquals(one.getQuote(), result);
    }
    
    @Test
    public void stockBuyOrder() {
        Stock one = new Stock("CS", "Computer", 5.00);
        Trader trader = new Trader(null, "one", "pass");
        TradeOrder order = new TradeOrder(trader, "CS", true, true, 10, 6.0);
        
        one.placeOrder( order );
        assertFalse(one.getBuyOrders().isEmpty());
    }
    
    @Test
    public void stockSellOrder() {
        Stock one = new Stock("CS", "Computer", 5.00);
        Trader trader = new Trader(null, "one", "pass");
        TradeOrder order = new TradeOrder(trader, "CS", false, true, 10, 6.0);
        
        one.placeOrder( order );
        assertFalse(one.getSellOrders().isEmpty());
    }
    
    @Test
    public void stockTwoMarket() {
        Stock one = new Stock("CS", "Computer", 5.00);
        
        Trader trader = new Trader(null, "one", "pass");
        Trader trader2 = new Trader(null, "two", "pass");
        TradeOrder order = new TradeOrder(trader, "CS", false, true, 10, 6.0);
        TradeOrder order2 = new TradeOrder(trader2, "CS", true, true, 10, 6.0 );
        
        one.placeOrder( order );
        one.placeOrder( order2 );
        assertTrue(one.getSellOrders().isEmpty()&& one.getBuyOrders().isEmpty());
    }
    
    @Test
    public void stockOneMarketOneLimit() {
        //Sell Order is market
        // Buy Order is limit
        Stock one = new Stock("CS", "Computer", 5.00);
        
        Trader trader = new Trader(null, "one", "pass");
        Trader trader2 = new Trader(null, "two", "pass");
        //Sell Order
        TradeOrder order = new TradeOrder(trader, "CS", false, true, 10, 6.0);
        //Buy Order
        TradeOrder order2 = new TradeOrder(trader2, "CS", true, false, 10, 5.0 );
        
        one.placeOrder( order );
        one.placeOrder( order2 );
        assertTrue(one.getLastPrice()==5.0);
    }
    
    @Test
    public void stockOneLimitOneMarket() {
        //Sell Order is limit
        // Buy Order is market
        Stock one = new Stock("CS", "Computer", 5.00);
        
        Trader trader = new Trader(null, "one", "pass");
        Trader trader2 = new Trader(null, "two", "pass");
        //Sell Order
        TradeOrder order = new TradeOrder(trader, "CS", false, false, 10, 6.0);
        //Buy Order
        TradeOrder order2 = new TradeOrder(trader2, "CS", true, true, 10, 5.0 );
        
        one.placeOrder( order );
        one.placeOrder( order2 );
        assertTrue(one.getLastPrice()==6.0);
    }
    
    @Test
    public void stockTwoLimit() {
      
        Stock one = new Stock("CS", "Computer", 5.00);
        
        Trader trader = new Trader(null, "one", "pass");
        Trader trader2 = new Trader(null, "two", "pass");
        //Sell Order
        TradeOrder order = new TradeOrder(trader, "CS", false, false, 10, 6.0);
        //Buy Order
        TradeOrder order2 = new TradeOrder(trader2, "CS", true, false, 10, 7.0 );
        
        one.placeOrder( order );
        one.placeOrder( order2 );
        assertTrue(one.getLastPrice()==6.0);
    }
    @Test
    public void stockHiPrice() {
        Stock one = new Stock("CS", "Computer", 5.00);
        
        Trader trader = new Trader(null, "one", "pass");
        Trader trader2 = new Trader(null, "two", "pass");
        //Sell Order
        TradeOrder order = new TradeOrder(trader, "CS", false, false, 10, 6.0);
        //Buy Order
        TradeOrder order2 = new TradeOrder(trader2, "CS", true, false, 10, 7.0 );
        
        
        
        
        one.placeOrder( order );
        one.placeOrder( order2 );
        
        assertTrue(one.getHiPrice()==6.0);
    }
    /*
    @Test
    public void stockLoPrice() {
        Stock one = new Stock("CS", "Computer", 5.00);
        
        Trader trader = new Trader(null, "one", "pass");
        Trader trader2 = new Trader(null, "two", "pass");
        
        //Sell Order
        TradeOrder order = new TradeOrder(trader, "CS", false, false, 10, 6.0);
        //Buy Order
        TradeOrder order2 = new TradeOrder(trader2, "CS", true, false, 10, 5.0 );
        
        
        
        
        one.placeOrder( order );
        
        System.out.println("Test");
        one.placeOrder( order2 );
        
        
        
        assertTrue(one.getLoPrice()==4.0);
    }
    
    
*/
    // Remove block comment below to run JUnit test in console
    /*
     * public static junit.framework.Test suite() { return new
     * JUnit4TestAdapter( JUSafeTradeTest.class ); }
     * 
     * public static void main( String args[] ) {
     * org.junit.runner.JUnitCore.main( "JUSafeTradeTest" ); }
     */
}

