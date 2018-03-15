package nl.saxion.hboict.ad.week3;

import nl.saxion.hboict.ad.resources.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tpo01 on 18/02/16.
 */
public class MyCityOverviewList implements CityOverview {

    private List<Person> phoneBook;

    @Override
    public long initialize(List<Person> phoneBook) {
        long startTime = System.currentTimeMillis();

        this.phoneBook = phoneBook;
        // We dont need to prepare anything...

        return System.currentTimeMillis() - startTime;
    }

    @Override
    public List<Person> getCitizensOf(String city) {
        ArrayList<Person> result = new ArrayList<Person>();

        for(Person p : phoneBook) {
            if(p.getAddress().getCity().equals(city)) {
                result.add(p);
            }
        }

        return result;
    }

    @Override
    public Set<String> getAllCities() {
        Set<String> cities = new HashSet<String>();

        for(Person p : phoneBook) {
            cities.add(p.getAddress().getCity());
        }

        return cities;
    }
}
