import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BannerAlt extends JApplet implements ActionListener
{
    private int xPos, yPos;

    private int msgID = 1;


    public void init()
    {

        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        xPos = c.getWidth();
        yPos = c.getHeight() / 2;
        Timer clock = new Timer( 2000, this ); // fires every 2 seconds

        clock.start();

    }


    // Called automatically after a repaint request
    public void paint( Graphics g )
    {
        super.paint( g );
        g.setColor( Color.BLUE );
        if ( msgID == 1 )
        {
            g.drawString( "East or West", 60, 65 );

        }
        else
        {
            g.drawString( "Java is the Best", 60, 65 );

        }
        msgID = -msgID;

    }


    // Called automatically when the timer fires
    public void actionPerformed( ActionEvent e )
    {
        Container c = getContentPane();

        // Adjust the horizontal position of the banner:
        xPos--;
        if ( xPos < -100 )
        {
            xPos = c.getWidth();
        }

        // Set the vertical position of the banner:
        yPos = c.getHeight() / 2;

        repaint();
    }
}
