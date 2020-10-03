//import java.awt.Color;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;
import java.util.*;
import gpdraw.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Twisha Sundararajan
 * @version Nov. 5, 2018
 *
 * @author Period - 5
 * @author Assignment - Irregular Polygon
 * 
 * @author Sources - TODO list collaborators
 */
public class IrregularPolygon
{
    private DrawingTool pen; //= new DrawingTool(
       // new SketchPad( 300, 300, 0 ) );

    private ArrayList<Point2D.Double> myPolygon;


    // constructors
    /**
     * Creates a new arrayList of points for a new polygon
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    // public methods
    /** 
     * 
     * Adds a point to the polygon/ array.
     * @param aPoint the point being added to the array
     */
    public void add( Point2D.Double aPoint )
    {
        if ( aPoint != null )
        {
            myPolygon.add( aPoint );
        }
    }

    /**
     * 
     * Calculates perimeter given array of all points.
     * @return double perimeter
     */
    public double perimeter()
    {
        double perim = 0;
        int size = myPolygon.size();
        if (size < 3) 
        {
            return 0.0;
        }
        double dist = 0; 
        
        for ( int i = 0; i < size - 1; i++ ) {
            dist = distance(myPolygon.get( i ), myPolygon.get( i + 1 ));
            perim += dist;
        }
        dist = distance(myPolygon.get( 0 ), myPolygon.get( size - 1 ));
        perim += dist;
        return perim;
    }
    /**
     * 
     * Helper method: returns distance given two points.
     * @param pt1 the first point being calculated
     * @param pt2 the second point being calculated
     * @return double distance between two points
     */
    public double distance(Double pt1, Double pt2) {
        double x1 = pt1.getX();
        double y1 = pt1.getY();
        double x2 = pt2.getX();
        double y2 = pt2.getY();
        double x = x2 - x1;
        double y = y2 - y1;
        double hyp = Math.sqrt( ( x * x ) + ( y * y ) );
        return hyp;
    }

    /** 
     * 
     * returns area of polygon.
     * @return double area
     */
    public double area()
    {
        double area = 0.0;
        int size = myPolygon.size();
        if (size < 3) 
        {
            return 0.0;
        }
        for (int i = 0; i < size - 1; i++) {
            area += myPolygon.get( i ).getX() * myPolygon.get( i + 1 ).getY();
        }
        area += myPolygon.get( size - 1 ).getX() * myPolygon.get( 0 ).getY();
        
        for (int i = 0; i < size - 1; i++) {
            area -= myPolygon.get( i ).getY() * myPolygon.get( i + 1 ).getX();
        }
        area -= myPolygon.get( size - 1 ).getY() * myPolygon.get( 0 ).getX();
        
        return Math.abs( area / 2.0);
    }
    /** 
     * 
     * Draws the polygon.
     */
    public void draw()
    {
        int size = myPolygon.size();
        if (size < 3) 
        {
            return;
        }
        pen.up();
        pen.move( myPolygon.get(0).getX(), myPolygon.get(0).getY());
        pen.down();
        
        for (int i = 1; i < size; i++) 
        {
            pen.move( myPolygon.get(i).getX(), myPolygon.get(i).getY());
        }
        pen.move( myPolygon.get(0).getX(), myPolygon.get(0).getY());
        
    }
}
