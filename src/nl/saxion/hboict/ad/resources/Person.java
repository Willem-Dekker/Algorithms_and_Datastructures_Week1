package nl.saxion.hboict.ad.resources;

/**
 * Basic class representing a Person.
 */
public class Person implements Comparable<Person> {

    private String initials;
    private String lastName;
    private Address address;
    private String phoneNumber;

    public Person(String initials, String lastName, String phoneNumber, Address address) {
        this.initials = initials;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String toString() {
        return lastName +", " + initials + ", " + address + ", " + phoneNumber;
    }

    public int compareTo(Person otherPerson) {
        return lastName.compareTo(otherPerson.lastName);
    }

    public String getInitials() {
        return initials;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
