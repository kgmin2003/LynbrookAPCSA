import java.util.*;


/**
 * Represents various States and their respective cities.
 *
 * @author Twisha Sundararajan
 * @version 4/8/2019
 * @author Period - 5
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - list collaborators
 */
public class States
{
    private Map<String, Set<String>> theMap;


    /**
     * states constructor
     */
    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }


    /**
     * postcondition: Information from theCity has been added to theMap * @param
     * theCity cityInfo city
     */
    public void addCityToMap( CityInfo theCity )
    {
        if ( theMap.containsKey( theCity.state() ) )
        {
            theMap.get( theCity.state() ).add( theCity.city() );
        }
        else
        {
            Set<String> setStr = new TreeSet<String>();
            setStr.add( theCity.city() );
            theMap.put( theCity.state(), setStr );
        }
    }


    /**
     * 
     * Prints one state from the set
     * 
     * @param theState
     *            string state
     */
    public void printOneState( String theState )
    {
        // not allowed since output is specified without the "[...]"
        // System.out.println(theState + " " + theMap.get(theState));

        Set<String> setStr = theMap.get( theState );
        String result = theState + " ";
        for ( String str : setStr )
        {
            result = result + str + " ";
        }
        System.out.println( result );
    }


    /**
     * 
     * prints all states from the set
     */
    public void printAllStates()
    {
        for ( String str : theMap.keySet() )
        {
            printOneState( str );
        }
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}
