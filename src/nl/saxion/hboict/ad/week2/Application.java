package nl.saxion.hboict.ad.week2;

import nl.saxion.hboict.ad.resources.Person;
import nl.saxion.hboict.ad.resources.PhoneBookParser;

import java.util.Collections;
import java.util.List;

/**
 * This is the main file which is used for week 2 of Algorithms & Data structures.
 * Most method-shells have been created for your convenience. I would strongly suggest you use them!
 */
public class Application {

    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        // Retrieve the phonebook in the form of a list.
        // You can experiment with the size of the Phonebook.
        System.out.print("Reading phonebook..\t\t");
        List<Person> phoneBook = PhoneBookParser.getPersons(100000);
        System.out.println("[DONE]");

        // Sort the list
        System.out.print("Sorting phonebook..\t\t");
        long startTime = System.currentTimeMillis();
        phoneBook = sort(phoneBook);
		long duration = (System.currentTimeMillis() - startTime);
        // End sorting

        // Keep this assert in place to make sure your array is sorted!
        // (And don't forget to enable assertions!)
		assert (phoneBook != null) : "The selected sorting algorithm is not implemented yet!";
		assert (isSorted(phoneBook)) : "List is not sorted!";

        System.out.println("[DONE] (" + duration + " ms)");
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
            case 2:
                return insertionSort(listToSort);
            case 3:
                return mergeSort(listToSort);
            case 4:
                return quickSort(listToSort);
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
     * Sort the list based on the insertion sort algorithm.
     *
     * @param listToSort The list to be sorted
     * @return A sorted list, based on the comparable implementation of Person.
     */
    private List<Person> insertionSort(List<Person> listToSort) {
        return null;
    }

    /**
     * Sort the list based on the merge sort algorithm.
     *
     * @param listToSort The list to be sorted
     * @return A sorted list, based on the comparable implementation of Person.
     */
    private List<Person> mergeSort(List<Person> listToSort) {
        return null;
    }

    /**
     * Sort the list based on the quick sort algorithm.
     *
     * @param listToSort The list to be sorted
     * @return A sorted list, based on the comparable implementation of Person.
     */
    private List<Person> quickSort(List<Person> listToSort) {
        return null;
    }

    /**
     * Convenience method to check if your list is actually sorted.
     *
     * @param list The list to be checked
     * @return True, if the list is sorted accordingly to the compareTo method implemetend by Person. False otherwise.
     */
    private boolean isSorted(List<Person> list) {
        if (list.size() < 2) {
            return true;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }

        return true;
    }
}
