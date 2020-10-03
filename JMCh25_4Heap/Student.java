/**
   Student.java

   Stores the following information about students
      grade
      name (first and last)
      Lynbrook id

 */
public class Student implements Comparable
{
    private String lynbrookId;
    private String firstName;
    private String lastName;
    private int grade;

    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }

    public Student()
    {
        this( "", "", "", 0 );
    }

    /**
     * Compares the grade of each student, and if the grades are equal then 
     * then compares Lynbrook id's and sort the students in increasing order 
     * by their Lynbrook id
     * 
     * @param obj
     * @return
     */
    public int compareTo( Object obj )
    {
        Student stu = (Student)obj;
        
        if ( grade == stu.grade )
        {
            return lynbrookId.compareTo(  stu.lynbrookId );
        }
        return grade - stu.grade;
    }

    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }

    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
