import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;


/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author TODO Doris Wei and Twisha Sundararajan
 * @version TODO October 16, 2018
 * @author Period: 5
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 * @author Sources: TODO
 */
public class Jumper extends Bug implements Edible
{
    private Location location;


    // TODO constructor(s)

    public Jumper()
    {
        super();
    }


    public Jumper( Color bugColor )
    {
        super( bugColor );
    }


    public void move()
    {
        Grid<Actor> grid = getGrid();
        if ( grid == null )
        {
            return;
        }
        Location loc = getLocation();
        Location adj = loc.getAdjacentLocation( getDirection() );
        Location jump = adj.getAdjacentLocation( getDirection() );
        if ( grid.isValid( jump ) )
        {
            moveTo( jump );
        }
        else
        {
            removeSelfFromGrid();
        }
    }


    public void act()
    {
        if ( canMove() )
        {
            move();
        }
        else
        {
            turn();
        }
    }


    // TODO method(s)

    public void turn()
    {
        super.turn();
    }


    public boolean canMove()
    {
        // if the bug reaches the end of grid
        Grid<Actor> grid = getGrid();
        if ( grid == null )
        {
            return false;
        }
        // if there is an object one space && two spaces in front
        Location loc = getLocation();
        Location adj = loc.getAdjacentLocation( getDirection() );
        Location jump = adj.getAdjacentLocation( getDirection() );
        if ( !grid.isValid( jump ) )
        {
            return false;
        }
        Actor neighbor = grid.get(jump);

        return (neighbor == null) || (neighbor instanceof Edible);
    }


   /* public Location getLocation()
    {
        return location;
    }


    public void removeSelfFromGrid()
    {
        Grid<Actor> grid = getGrid();

        if ( grid.get( location ) == this )
        {
            throw new IllegalStateException(
                "The grid contains a different actor at location "
                    + location + "." );

        }

        grid.remove( getLocation() );
        grid = null;
        location = null;
    }*/

}