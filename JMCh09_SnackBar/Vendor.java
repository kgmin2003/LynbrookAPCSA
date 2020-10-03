import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO 10/1/18
 * 
 * @author Period - TODO 5
 * @author Assignment - Java Methods Ch09 - SnackBar
 * 
 * @author Sources - TODO list collaborators
 */
public class Vendor

{
    // Fields:

    private int stock = 5; // # items in stock

    private int deposit; // $ deposited

    private int price; // price of single item

    private int change; // deposit - price

    private static double totalSales;


    // Constructor
    // Parameters:
    // int price of a single item in cents
    // int number of items to place in stock
    /**
     * 
     * sets price
     * 
     * @param price
     *            is the cost of the item
     * @param stock
     *            is how many items are there
     */

    public Vendor( int price, int stock )
    {
        this.price = price;
    }


    // Sets the quantity of items in stock.
    // Parameters:
    // int number of items to place in stock
    // Return:
    // None
    /**
     * sets the sets stock.
     * 
     * @param stock
     *            how many items in stock
     */
    public void setStock( int stock )
    {
        this.stock = stock;
    }


    // Returns the number of items currently in stock.
    // Parameters:
    // None
    // Return:
    // int number of items currently in stock
    /**
     * Returns the value of the most recent stock update.
     * 
     * @return stock
     */
    public int getStock()
    {
        return stock;
    }


    // Adds a specified amount (in cents) to the deposited amount.
    // Parameters:
    // int number of cents to add to the deposit
    // Return:
    // None
    /**
     * sets the "table" boundaries.
     * 
     * @param cents
     *            is how much money is returned when change is needed
     */

    public void addMoney( int cents )
    {
        if ( stock < 0 )
        {
            change = cents;
        }
        else
        {
            deposit += cents;

        }
    }


    // Returns the currently deposited amount (in cents).
    // Parameters:
    // None
    // Return:
    // int number of cents in the current deposit
    /**
     * Returns the value of the most recent deposit.
     * 
     * @return deposit
     */
    public int getDeposit()
    {
        if ( stock == 0 )
        {
            deposit = 0;
        }
        return deposit;
    }


    // Implements a sale. If there are items in stock and
    // the deposited amount is greater than or equal to
    // the single item price, then adjusts the stock
    // and calculates and sets change and returns true;
    // otherwise refunds the whole deposit (moves it into change)
    // and returns false.
    // Parameters:
    // None
    // Return:
    // boolean successful sale (true) or failure (false)
    /**
     * Returns the whether a sale is made updates all data-types accordingly.
     * 
     * @return boolean whether sale occurs
     */
    public boolean makeSale()
    {
        if ( stock > 0 && deposit >= price )
        {

            change = deposit - price;
            totalSales += (double)( ( price ) * .01 );
            deposit = 0;
            stock -= 1;
            return true;
        }
        else
        {
            change = deposit;
            deposit = 0;
            return false;
        }
    }


    // Returns and zeroes out the amount of change (from the last
    // sale or refund).
    // Parameters:
    // None
    // Return:
    // int number of cents in the current change
    /**
     * sets change equal to a temp to return and reset change.
     * 
     * @return temp which holds original value of change w
     */
    public int getChange()
    {
        int temp = change;
        change = 0;
        return temp;
    }


    // Returns the current value of totalSales.
    // Parameters:
    // None
    // Return:
    // amount of all sales (in dollars)
    /**
     * Returns the total amount of money made.
     * 
     * @return temp
     */
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0;
        return temp;
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Vendor.
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
                str += separator + field.getName() + ":"
                    + field.get( this );
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
