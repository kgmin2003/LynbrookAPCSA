import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author TODO Twisha Sundararajan
 * @version TODO 10/7/18
 * @author Period: TODO 5
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: TODO List collaborators
 */
public class ComplexJUTest extends junit.framework.TestCase
{

    @Test
    public void testConstructor1Param()
    {
        Complex c = new Complex( 1 );
        assertEquals( "1.0 + 0.0i", c.toString() );
    }


    @Test
    public void testConstructor2Param()
    {
        Complex c = new Complex( 3, 4 );
        assertEquals( "3.0 + 4.0i", c.toString() );
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        Complex c2 = new Complex( 1, 2 );
        Complex c3 = c2.add( 4.0 );
        assertEquals( "5.0 + 2.0i", c3.toString() );
    }


    @Test
    public void testAdd2ComplexNums()
    {
        Complex c1 = new Complex( 3, 4 );
        Complex c2 = new Complex( 2, 3 );
        Complex c3 = c1.add( c2 );
        assertEquals( "5.0 + 7.0i", c3.toString() );
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        Complex c1 = new Complex( 1, 2 );
        Complex c2 = new Complex( 3, 4 );
        Complex c3 = c1.multiply( c2 );
        assertEquals( "-5.0 + 10.0i", c3.toString() );
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex c2 = new Complex( 3, 4 );
        Complex c3 = c2.multiply( 2.0 );
        assertEquals( "6.0 + 8.0i", c3.toString() );
    }


    @Test
    public void testAbsoluteValue()
    {
        Complex c2 = new Complex( 3, 4 );
        Double c3 = c2.abs();
        assertEquals( "5.0", c3.toString() );

    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
