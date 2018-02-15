package nl.saxion.hboict.ad.resources;

/**
 * Basic class representing an Address.
 */
public class Address {

    private String postalCode;
    private String streetName;
    private int buildingNumber;
    private String city;
    private String municipality;

    public Address(String postalCode, String streetName, int buildingNumber, String city, String municipality) {
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.municipality = municipality;
    }

    public String toString() {
        return streetName + " " + buildingNumber + ", " + postalCode + ", " + city + " (" + municipality + ")";
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public String getMunicipality() {
        return municipality;
    }
}
