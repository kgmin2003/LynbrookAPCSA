/**
 * Skeleton class that implements the CityInfo Interface
 *
 * @author Twisha Sundararajan
 * @version 4/8/2019
 * @author Period - 5
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - list collaborators
 */
public class USCity implements CityInfo
{
    private String city;
    private String state;

    public USCity (String city, String state)
    {
        this.city = city;
        this.state = state;
    }

    public String city()
    {
        return city;
    }

    public String state()
    {
        return state;
    }

    public String toString()
    {
        return city() + ", " + state();
    }

}
