/**
 * TODO Write a one-sentence summary of your class here.
 *
 * @author TODO Twisha Sundararajan
 * @version TODO 9/10/18
 * @author Period: TODO 5
 * @author Assignment: JMCh06_10PieChart
 *
 * @author Sources: TODO list collaborators
 */
public class PollTest
{
    /**
     * TODO Tests the poll display.
     * 
     * @param args run the program by showing the voting machine and 
     * incrementing the vote counts and displaying the results
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami",
            "Brian",
            "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
