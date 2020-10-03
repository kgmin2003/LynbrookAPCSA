import java.util.Map;
import java.util.Set;

/**
 * States class test shroud
 *
 * @author Twisha Sundararajan
 * @version 4/8/2019
 * @author Period - 5
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - list collaborators
 */
public class TestStates
{
    public static void main(String[] args)
    {
        States stateMap = new States();

        stateMap.addCityToMap(new USCity("Albany", "NY"));
        stateMap.addCityToMap(new USCity("Miami", "FL"));
        stateMap.addCityToMap(new USCity("Hamilton", "NY"));
        stateMap.addCityToMap(new USCity("Jacksonville", "FL"));
        stateMap.addCityToMap(new USCity("Dallas", "TX"));
        
        USCity city1 = new USCity("Albany", "GA");
        USCity city2 = new USCity("Houston", "TX");
        
        stateMap.addCityToMap(city1);
        stateMap.addCityToMap(city2);
        

        stateMap.printOneState("FL");
        System.out.println();
        stateMap.printAllStates();
    }

}
