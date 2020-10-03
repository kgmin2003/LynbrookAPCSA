/**
 * 
 * Creates a college student.
 * 
 * @author Twisha Sundararajan
 * @version 2018-10-21)
 * 
 * @author Period - 5
 * @author Assignment - Assignment Name
 */
public class CollegeStudent extends Student
{
    // instance variables
    private String myMajor; // major of college student

    private int myYear; // year of student


    // constructor
    /**
     * Creates a college student.
     * 
     * @param name
     *            college student's name.
     * @param age
     *            college student's age
     * @param gender
     *            college student's gender
     * @param idNum
     *            college student's id number
     * @param gpa
     *            college student's gpa
     * @param year
     *            college student's year
     * @param major
     *            college student's major
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa,
        int year,
        String major )
    {
        super( name, age, gender, idNum, gpa );

        myMajor = major;
        myYear = year;
    }


    // methods
    /**
     * @return major major of college student
     */
    public String getMajor()
    {
        return myMajor;
    }


    /**
     * @return year current year of college student
     */
    public int getYear()
    {
        return myYear;
    }


    /**
     * 
     * @param major
     *            major of college student
     */
    public void setMajor( String major )
    {
        myMajor = major;
    }


    /**
     * 
     * @param year
     *            current year of college student
     */
    public void setYear( int year )
    {
        myYear = year;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: "
            + myMajor;
    }
}
