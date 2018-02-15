package nl.saxion.hboict.ad.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple PhoneBookParser, so you don't have to..
 * There should be no errors in the provided phoneBook (and thus the codes does not take that into account).
 * Do not forget to change the INPUT_LOCATION!
 */
public class PhoneBookParser {

    private static final String INPUT_LOCATION = "phonebook.csv";

    public static List<Person> getPersons(int amountOfPersons) {
        ArrayList<Person> result = new ArrayList<Person>(amountOfPersons);

        try {
            BufferedReader in = new BufferedReader(new FileReader(INPUT_LOCATION));

            String currentLine;
            String[] inputValues;
            int count = 0;

            while((currentLine = in.readLine()) != null && count < amountOfPersons) {
                inputValues = currentLine.split(";");

                Address address = new Address(inputValues[2], inputValues[3], Integer.parseInt(inputValues[4]), inputValues[5], inputValues[6]);
                Person person = new Person(inputValues[1], inputValues[0], inputValues[7], address);

                result.add(person);
                count++;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Unable to find file " + INPUT_LOCATION);
            e.printStackTrace();
        }  catch (Exception e) {
            // Obviously catching all exceptions is wrong..
            System.err.println("Something terrible happened!");
            e.printStackTrace();
        }

        return result;
    }
}
