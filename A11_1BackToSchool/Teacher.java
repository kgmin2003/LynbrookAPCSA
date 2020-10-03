/**
 * Creates a teacher.
 * 
 * @author Twisha Sundararajan
 * @version 2018-10-21)
 * 
 * @author Period - 5
 * @author Assignment - Assignment Name
 * 
 */
public class Teacher extends Person
{
    // instance variables
    private String mySubject; // subject of teacher

    private double mySalary; // salary of teacher


    // constructor
    /**
     * Creates a teacher object.
     * 
     * @param name
     *            teacher's name.
     * @param age
     *            teacher's age
     * @param gender
     *            teacher's gender
     * @param subject
     *            teacher's subject
     * @param salary
     *            teacher's salary
     */
    public Teacher(
        String name,
        int age,
        String gender,
        String subject,
        double salary )
    {
        super( name, age, gender );

        mySubject = subject;
        mySalary = salary;
    }


    // methods
    /**
     * @return subject subject of teacher
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * @return salary teacher's salary
     */
    public double getSalary()
    {
        return mySalary;
    }


    /**
     * 
     * @param subject
     *            subject to set
     */
    public void setSubject( String subject )
    {
        mySubject = subject;
    }


    /**
     * 
     * @param salary
     *            salary to set
     */
    public void setSalary( double salary )
    {
        mySalary = salary;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: "
            + mySalary;
    }
}
