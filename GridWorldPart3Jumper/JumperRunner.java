import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  TODO Doris Wei & Twisha Sundararajan
 *  @version TODO October 16, 2018
 *  @author  Period: 5
 *  @author  Assignment: GridWorld_Part3_Jumper
 *
 *  @author  Sources: TODO
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper());
        world.add(new Flower());
        world.add(new Rock());
        world.add(new Bug());
        world.show();
    }
}