import java.awt.*;
import javax.swing.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO 9/20/18
 * 
 * Period - TODO 5 - A12.6 - ParallelLines
 * 
 * Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{
    int offset;

    int x = 0;


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * TODO draws the illusion with lines and boxes.
     * 
     * @param g
     * @param width
     * @param height
     * @param size
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        for ( int row = 0; row <= 7; row++ )
        {
            // calculate the start of the row of squares
            offset = row * ( width / 7 );

            for ( int col = 0; col <= 7; col++ )
            {

                // calculate the start of the row of squares

                if ( col % 4 == 0 )
                {
                    x = 0;
                }
                else if ( col % 4 == 1 || col % 4 == 3 )
                {
                    x = 20;
                }
                if ( col % 4 == 2 )
                {
                    x = 40;
                }

                // draw squares
                g.fillRect(x + offset, height / 8 * col, width / 14, height / 8);

            }
            
            g.drawLine( 0,( height / 8 ) * row, width, ( height / 8 ) * row );

        }
    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
