package nl.saxion.hboict.ad.week3;

import nl.saxion.hboict.ad.resources.Person;
import nl.saxion.hboict.ad.resources.PhoneBookParser;

import java.util.*;

/**
 * This is the main file which is used for week 3 of Algorithms & Data structures.
 * Most method-shells have been created for your convenience. I would strongly suggest you use them!
 */
public class ApplicationWeek3 {

    public static void main(String[] args) {
        new ApplicationWeek3().run();
    }

    private static final int AMOUNT_OF_PERSONS = 10000;

    public void run() {
        // Retrieve the phonebook in the form of a list.
        // You can experiment with the size of the Phonebook.
        System.out.print("Reading phonebook..\t\t");
        List<Person> phoneBook = PhoneBookParser.getPersons(AMOUNT_OF_PERSONS);
        System.out.println("[DONE]");

        // Select your own implementation of a CityOverview
        CityOverview myCityOverview = new MyCityOverviewList();

        System.out.print("Initializing dataset.. \t");
        long initTime = myCityOverview.initialize(phoneBook);
        System.out.println("[DONE] ("+ initTime + " ms)");

        // Start measurement
        long startTime = System.currentTimeMillis();

        // Additional test to see if we actually counted all persons
        int amountOfCitizens = 0;

        for(String city : myCityOverview.getAllCities()) {
            int citizensInCity = myCityOverview.getCitizensOf(city).size();
            System.out.println(city + ": " + citizensInCity);
            amountOfCitizens += citizensInCity;
        }

        assert (amountOfCitizens == AMOUNT_OF_PERSONS) : "We lost a few people!";

        System.out.println("Printing of all cities and the amount of inhabitants took " + (System.currentTimeMillis() - startTime) + " ms. (init: " + initTime + " ms.)");
    }

}
