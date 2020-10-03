/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author TODO Twisha Sundararajan
 * @version TODO 10/7/18
 * @author Period: TODO 5
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: TODO List collaborators
 */
public class Complex
{
    // instance variables

    private double r;

    private double i;


    // Constructors
    /**
     * 
     * 
     * @param a
     *            the real number coefficient
     * 
     */

    public Complex( double a )
    {
        r = a;
    }


    /**
     * 
     * 
     * @param a
     *            the real number coefficient
     * @param b
     *            the imaginary number coefficient
     */

    public Complex( double a, double b )
    {
        r = a;
        i = b;
    }


    // Methods
    /**
     * 
     * 
     * 
     * @return double the magnitude of the addition of the square
     * 
     */

    public double abs()
    {
        return Math.sqrt( r * r + i * i );

    }


    /**
     * 
     * adds
     * 
     * @param other
     *            the other Complex number that will be added to the original
     *            one
     * @return complex returns the sum of the 2 complex numbers
     */

    public Complex add( Complex other )
    {
        double a = r + other.r;
        double b = i + other.i;
        Complex c3 = new Complex(a, b);
        return c3;
    }


    /**
     * 
     * multiplies
     * 
     * @param other
     * 
     *            the other Complex number that will be added to the original
     *            one
     * @return complex returns the product of the 2 complex numbers
     */

    public Complex multiply( Complex other )
    {
        double e = r * other.r - i * other.i;
        double f = i * other.r + other.i * r;
        Complex c3 = new Complex(e, f);
        return c3;
    }


    /**
     * 
     * adds
     * 
     * @param c
     *            the real number that will be added to the original one
     * @return complex returns the sum of a complex number and a real number
     */
    public Complex add( double c )
    {
       
        return  new Complex(r + c, i);
    }


    /**
     * 
     * multiplies
     * 
     * @param c
     *            the real number
     * @return complex returns the product of the complex number and the real
     */
    public Complex multiply( double c )
    {
        
        return new Complex(r * c, i * c);
    }


    /**
     * 
     * converts to String
     * 
     * 
     * @return string converts double or complex into a String
     */

    public String toString()
    {
       
        return r + " + " + i + "i";
    }
}
