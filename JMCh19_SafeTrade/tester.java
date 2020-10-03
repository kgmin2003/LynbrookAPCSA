import java.util.ArrayList;

public class tester
{
      
   
   
    


    public static void main( String[] args )
    {
        ArrayList <String> x = new ArrayList<String>()
        {
            { 
            add("1"); 
            add("2"); 
            add("3"); 
            }
        };
        System.out.println( x.get( 1 ) );
        System.out.println( x.get( 2 ) );


    }

}
