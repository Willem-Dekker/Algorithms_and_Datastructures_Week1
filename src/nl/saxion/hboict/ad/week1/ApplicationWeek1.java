package nl.saxion.hboict.ad.week1;

import nl.saxion.hboict.ad.resources.Address;
import nl.saxion.hboict.ad.resources.Person;
import nl.saxion.hboict.ad.resources.PhoneBookParser;

import java.util.Collections;
import java.util.List;

/**
 * This is the main file which is used for week 1 of Algorithms & Data structures.
 * You can just add your code to the run method. Most method-shells have been created
 * for your convenience. I would strongly suggest you use them!
 */
public class ApplicationWeek1 {

    private static final int AMOUNT_OF_RUNS_FOR_TESTING = 20;

    public static void main(String[] args) {
        new ApplicationWeek1().run();
    }

    public void run() {
        // Retrieve the phonebook in the form of a list.
        // You can experiment with the size of the Phonebook.
        System.out.print("Reading phonebook..\t\t");
        List<Person> phoneBook = PhoneBookParser.getPersons(1000000);
        System.out.println("[DONE]");

        System.out.print("Adding dummy user..\t\t");
        // Add a person which we can actually find..
        // Again: no changes are needed.
        Address address = new Address("7511JL", "van Galenstraat", 19, "Enschede", "Overijssel");
        Person findMe = new Person("A.", "ZzzFindMe", "0000000000", address);

        // You can change the place "ZzzFindMe" can be found. Experiment with this!
        phoneBook.add(0, findMe);

        System.out.println("[DONE]");

        // Sort the list -- Disable these lines if you want to use linear search on an unsorted list.
        System.out.print("Sorting phonebook..\t\t");
        long startTime = System.currentTimeMillis();
        phoneBook = sort(phoneBook);
        System.out.println("[DONE] (" + (System.currentTimeMillis() - startTime) + " ms)");
        // End sorting

        // Keep this assert in place to make sure your array is sorted!
        // However, if you want to use linear search with an unsorted array, disable this!
        assert isSorted(phoneBook) : "List is not sorted!";

        // Perform the actual testing. No changes are required.
        System.out.println("Running measurements..");
        System.out.println("Average Linear Time: " + executeLinearSearch(phoneBook, findMe) / 1000000.0 + " ms.");                       // Assignment 1
        System.out.println("Average Binary Time: " + executeBinarySearch(phoneBook, findMe) / 1000000.0 + " ms.");                       // Assignment 2
        System.out.println("Average Recursive Binary Time: " + executeBinaryRecursiveSearch(phoneBook, findMe) / 1000000.0 + " ms.");    // Assignment 3

    }

    /**
     * Convenience method which provides time calculation (in nanoseconds) for the linear search algorithm.
     *
     * @param whoToFind The Person instance which needs to be retrieved from the list.
     * @return The time it took to find the Person instance in the list.
     */
    private long executeLinearSearch(List<Person> phoneBook, Person whoToFind) {
        long totalTime = 0;

        for (int i = 0; i < AMOUNT_OF_RUNS_FOR_TESTING; i++) {
            long startTime = System.nanoTime();

            Person foundPerson = findPersonByNameLinear(phoneBook, whoToFind.getLastName());

            assert foundPerson == null || foundPerson.getLastName().equals(whoToFind.getLastName()) : "I found the wrong person!";

            totalTime += (System.nanoTime() - startTime);
        }

        return totalTime / AMOUNT_OF_RUNS_FOR_TESTING;
    }

    /**
     * Helper method which provides time calculation (in nanoseconds) for the binary search algorithm.
     *
     * @param whoToFind The Person instance which needs to be retrieved from the list.
     * @return The time it took to find the Person instance in the list.
     */
    private long executeBinarySearch(List<Person> phoneBook, Person whoToFind) {
        long totalTime = 0;

        for (int i = 0; i < AMOUNT_OF_RUNS_FOR_TESTING; i++) {
            long startTime = System.nanoTime();

            Person foundPerson = findPersonByNameBinary(phoneBook, whoToFind.getLastName());
            assert foundPerson == null || foundPerson.getLastName().equals(whoToFind.getLastName()) : "I found the wrong person!";

            totalTime += (System.nanoTime() - startTime);
        }

        return totalTime / AMOUNT_OF_RUNS_FOR_TESTING;
    }

    /**
     * Helper method which provides time calculation (in nanoseconds) for the recursive binary search algorithm.
     *
     * @param whoToFind The Person instance which needs to be retrieved from the list.
     * @return The time it took to find the Person instance in the list.
     */
    private long executeBinaryRecursiveSearch(List<Person> phoneBook, Person whoToFind) {
        long totalTime = 0;

        for (int i = 0; i < AMOUNT_OF_RUNS_FOR_TESTING; i++) {
            long startTime = System.nanoTime();

            Person foundPerson = findPersonByNameBinaryRecursive(phoneBook, whoToFind.getLastName());
            assert foundPerson == null || foundPerson.getLastName().equals(whoToFind.getLastName()) : "I found the wrong person!";

            totalTime += (System.nanoTime() - startTime);
        }

        return totalTime / AMOUNT_OF_RUNS_FOR_TESTING;
    }

    /**
     * Find a person, based on linear searching.
     * It should return either the person with the given lastName or null if the person cannot be found.
     *
     * @param lastName The last name of the person you want to find.
     * @return The instance of Person matching the lastName of the person or null.
     */
    private Person findPersonByNameLinear(List<Person> phoneBook, String lastName) {
        for (Person p : phoneBook) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }

        return null;
    }

    /**
     * Find a person, based on binary searching.
     * It should return either the person with the given lastName or null if the person cannot be found.
     *
     * @param lastName The last name of the person you want to find.
     * @return The instance of Person matching the lastName of the person or null.
     */
    private Person findPersonByNameBinary(List<Person> phoneBook, String lastName) {
        int left = 0, right = phoneBook.size()-1, middle = (left+right)/2; //setting vars for the sort
        while(!phoneBook.get(middle).getLastName().equals(lastName) && left < right){ //while the lastname in the middle is not the one we need AND left is less then right
            int compareToNumber = phoneBook.get(middle).getLastName().compareTo(lastName); //check if the lastname is lower or higher in the alphabet
            if (compareToNumber < 0){ //if the name is higher in the alphabet
                left = middle + 1; // left is the old middle plus one
            }else if (compareToNumber > 0){ // if the name is lower in the alphabet
                right = middle - 1; //right is the middle minus one
            }
            middle = (left + right) / 2; //the new middle is de diverence between left and right
        }
        if (phoneBook.get(middle).getLastName().equals(lastName)){ //if the lastname in the middle is equeal to the one we need
            return phoneBook.get(middle); //return the person
        }else { //the lastname was not found.
            return null; //return null
        }
    }


    /**
     * Find a person, based on binary searching recursively.
     * It should return either the person with the given lastName or null if the person cannot be found.
     *
     * @param lastName The last name of the person you want to find.
     * @return The instance of Person matching the lastName of the person or null.
     */
    private Person findPersonByNameBinaryRecursive(List<Person> phoneBook, String lastName) {

        return null;
    }


    /**
     * Sorts the list based on the comparable interface implemented by Person.
     *
     * @param listToSort The list that needs sorting.
     * @return A sorted list.
     */
    private List<Person> sort(List<Person> listToSort) {
        // Change this to change the method of sorting
        // You can add more sorting algorithms here
        int sortingAlgorithm = -1;

        switch (sortingAlgorithm) {
            case 1:
                return selectionSort(listToSort);
            // Add more sorting algorithms here
            default:
                // Default sorting method will be Collections.sort(...) on the input values.
                // You should really try to implement your own sorting algorithm!
                // But Collections.sort(...) is really, really fast! So don't expect it to be faster. :-)
                Collections.sort(listToSort);
                return listToSort;
        }
    }

    /**
     * Sort the list based on the selection sort algorithm.
     *
     * @param listToSort The list to be sorted
     * @return A sorted list, based on the comparable implementation of Person.
     */
    private List<Person> selectionSort(List<Person> listToSort) {
        return null;
    }


    /**
     * Convenience method to check if your list is actually sorted.
     *
     * @param list The list to be checked
     * @return True, if the list is sorted accordingly to the compareTo method implemetend by Person. False otherwise.
     */
    private boolean isSorted(List<Person> list) {

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }

        return true;
    }
}
