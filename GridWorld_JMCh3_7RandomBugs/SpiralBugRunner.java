import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;

/**
   TODO This class runs the bug that goes in a spiral.

   @author  TODO Twisha Sundararajan
   @version TODO 9/3/18

   @author  Period - TODO 5
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBugRunner

   @author  Sources - TODO list collaborators
 */
public class SpiralBugRunner
{
    public static void main( String[] args )
    {
        UnboundedGrid<Actor> grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld( grid );

        SpiralBug alice = new SpiralBug(3);
        alice.setColor(Color.ORANGE);
        world.add(new Location(9, 9), alice);
        world.show();    }
}