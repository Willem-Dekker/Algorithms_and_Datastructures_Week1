package nl.saxion.hboict.ad.week3;

import nl.saxion.hboict.ad.resources.Person;
import java.util.List;
import java.util.Set;

/**
 * Interface for CityOverview
 * Basically, you need to first initialize the city overview using the phone book.
 * Next you can query it by using the getCiitzensOf(..) method.
 */
public interface CityOverview {

    /**
     * Initializes the CityOverview based on a phone book.
     * @param phoneBook The source dataset. (Use PhoneBookParser here.)
     * @return The amount of ms it took to initialize
     */
    long initialize(List<Person> phoneBook);

    /**
     * Returns the list of inhabitants for a city with provided name.
     * @param city The name of city for which a list has to be returned
     * @return The list of Person instances of all inhabitants of a certain city
     */
    List<Person> getCitizensOf(String city);

    /**
     * Returns the list of all cities from the phone book.
     * @return Set of String representations of all cities
     */
    Set<String> getAllCities();
}
