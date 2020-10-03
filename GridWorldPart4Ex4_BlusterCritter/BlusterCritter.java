import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;


/**
 * Creates a shy bug 
 *
 * @author Twisha Sundararajan
 * @version Nov. 13, 2018
 * @author Period: 5
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 */
public class BlusterCritter extends Critter
{
    private static final Color DEFAULT_COLOR = Color.PINK;

    // private static final double DARKENING_FACTOR = 0.05;

    private int critters;


    /**
     * Creates a bluster critter
     * 
     * @param c
     *            darkness factor
     */
    public BlusterCritter( int c )
    {
        setColor( DEFAULT_COLOR );
        critters = c;
    }


    /**
     * checks surrounding neighbors to see if it is filled w actor
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();

        Grid<Actor> gr = getGrid();

        Location loc = getLocation();
        int x = loc.getRow();
        int y = loc.getCol();

        for ( int i = x - 2; i <= x + 2; i++ )
        {
            for ( int j = y - 2; j <= y + 2; j++ )
            {
                Location temp = new Location( i, j );
                if ( getGrid().isValid( temp ) )
                {
                    Actor a = gr.get( temp );
                    if ( a != null && a != this )
                    {
                        actors.add( a );
                    }

                }
            }
        }
        // System.out.println( actors );
        return actors;

    }


    /**
     * Changes color of bug
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        if ( actors.size() < critters )
        {
            lighten();
        }
        else
        {
            darken();
        }
    }


    /**
     * makes the color of the bug darker
     */
    private void darken()
    {
        Color bugColor = getColor();
        setColor( bugColor.darker() );
    }


    /**
     * makes the color of the bug lighter
     */
    private void lighten()
    {
        Color bugColor = getColor();
        setColor( bugColor.brighter() );
    }
}
