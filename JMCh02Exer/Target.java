
// Question 2-13-b

import java.awt.*;
import javax.swing.*;


/**
 * This program displays a red cross on a white background.
 */

public class Target extends JPanel
{
    public void paintComponent( Graphics o )
    {
        super.paintComponent( o ); // Call JPanel's paintComponent method
                                   // to paint the background

        o.setColor( Color.RED );
        o.fillOval( 100, 100, 100, 100 );
        o.setColor( Color.WHITE );
        o.fillOval( 112, 110, 77, 77 );
        o.setColor( Color.RED );
        o.fillOval( 123, 122, 55, 55 );

    }


    public static void main( String[] args )
    {
        JFrame window = new JFrame( "Target" );
        window.setBounds( 400, 400, 400, 400 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Target panel = new Target();
        panel.setBackground( Color.WHITE );
        Container c = window.getContentPane();
        c.add( panel );
        window.setVisible( true );
    }
}
