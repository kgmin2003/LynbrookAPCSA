import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;


/**
 * TODO This class runs the bug that turns once everytime it hits an obstacle.
 * 
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO 9/3/18
 * 
 * @author Period - TODO 5
 * @author Assignment - GridWorld Part 2, Random Bugs - CircleBugRunner
 * 
 * @author Sources - TODO list collaborators
 */
public class CircleBugRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug( 6 );
        alice.setColor( Color.ORANGE );
        CircleBug bob = new CircleBug( 3 );
        world.add( new Location( 7, 8 ), alice );
        world.add( new Location( 5, 5 ), bob );
        world.show();
    }
}