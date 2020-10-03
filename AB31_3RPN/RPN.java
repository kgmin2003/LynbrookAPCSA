import java.util.*;


/**
 * RPN Calculator
 *
 * @author Twisha Sundararajan
 * @version Jan 15, 2019
 * @author Period: 5
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: List Collaborators
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * Processes all entered characters and calculates values
     */
    public void calculate()
    {
        String str = "";
        str = scan.next();
        while ( !str.equals( "q" ) && !str.equals( "Q" ) )
        {
                char ch = str.charAt( 0 );

                switch ( ch )
                {
                    case '*':
                    {
                        multipliez();
                        break;
                    }
                    case '/':
                    {
                        dividez();
                        break;
                    }
                    case '+':
                    {
                        addz();
                        break;
                    }
                    case '-':
                    {
                        subtractz();
                        break;
                    }
                    default:
                    {
                        myQ.add( Character.toString( ch ) );
                        myStack.push( Character.getNumericValue( ch ) );
                        break;
                }

            }
            str = scan.next();
        }
        caseQ();
   }


    /**
     * 
     * When q is entered, clears myStack and myQ prints results
     * 
     */
    public void caseQ()
    {
        while ( !myQ.isEmpty() )
        {
            System.out.print( myQ.remove() + " " );
        }
        System.out.println( "= " + myStack.pop() );

    }
    /**
     * 
     * Add elements
     * 
     */
    public void addz() 
    {
        myQ.add( "+" );
        int temp = myStack.pop() + myStack.pop();
        myStack.push( temp );
    }
    /**
     * 
     * subtracts elements
     * 
     */
    public void subtractz() 
    {
        myQ.add( "-" );
        myStack.push( -myStack.pop() + myStack.pop() );
    }
    /**
     * 
     * divides elements
     * 
     */
    public void dividez() 
    {
        myQ.add( "/" );
        int temp = myStack.pop();
        myStack.push( myStack.pop() / temp );
    }
    /**
     * 
     * multiplies elements
     * 
     */
    public void multipliez() 
    {
        myQ.add( "*" );
        myStack.push( myStack.pop() * myStack.pop() );
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN(); //"9\n5\n-\nQ\n"
        rpn.calculate();
    }
}