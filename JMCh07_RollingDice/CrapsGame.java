/**
 * Implements the game of Craps logic.
 *
 * @author TODO Twisha Sundararajan
 * @version TODO 9/16/18
 * @author Period: TODO 5
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: TODO collaborators
 */
public class CrapsGame
{
    private int point = 0;


    /**
     * Calculates the result of the next dice roll in the Craps game. The
     * parameter total is the sum of dots on two dice. point is set to the saved
     * total, if the game continues, or 0, if the game has ended. Returns 1 if
     * player won, -1 if player lost, 0 if player continues rolling.
     * 
     * @return result = 1 if won, 0 if continues, and -1 if lost
     * @param total
     *            is the sum of two dice rolls
     */
    public int processRoll( int total )
    {
        int result = 0;

        if ( point > 0 )
        {
            if ( total == 7 )
            {
                point = 0;
                result = -1;
            }
            else if ( total == point )
            {
                point = 0;
                result = 1;
            }
            else
            {
                result = 0;
            }
        }

        else if ( total == 11 || total == 7 || total == point )
        {
            point = 0;
            result = 1;
        }

        else if ( total == 2 || total == 3 || total == 12 )
        {
            point = 0;
            result = -1;
        }

        else
        {
            result = 0;
            this.point = total;
        }

        return result;
    }


    /**
     * getter method
     * 
     * @return the saved point
     */
    public int getPoint()
    {
        return point;
    }
}