import info.gridworld.actor.Bug;


/**
 * TODO This class defines and constructs variables, constructors, and methods
 * TODO These fields can be called from the runner class.
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO 9/4/18
 * 
 * @author Period - TODO 5
 * @author Assignment - GridWorld Part 2, Exercise 2 - SpiralBug
 * 
 * @author Sources - TODO list collaborators
 */

public class SpiralBug extends Bug
{
    private int steps;

    private int sideLength;


    /**
     * Constructs a box bug that traces a square of a given side length
     * 
     * @param length
     *            the side length
     */
    public SpiralBug( int length )
    {
        steps = 0;
        sideLength = length;
    }


    /**
     * Moves to the next location of the square.
     */
    public void act()
    {

        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }
}
