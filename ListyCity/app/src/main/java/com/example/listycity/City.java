package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that represents a City
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /**
     * This method compares the names of City objects
     * @param o the object to be compared.
     * @return 0, {@literal <} 1, or {@literal >} 1 if the values are equal, a {@literal <} b, or a {@literal >} b
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * This method overrides how City objects are compared
     *
     * Code is adapted from "Comparing Java objects with equals() and hashcode()"
     * By Rafael del Nero
     * Published May 16, 2024
     * https://www.infoworld.com/article/2256967/comparing-java-objects-with-equals-and-hashcode.html
     *
     * @param object
     *   The object this class is being compared to
     * @return
     *   A boolean depending on if the objects are same or not
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return city.equals(((City) object).getCityName()) && province.equals(((City) object).getProvinceName());

    }

    /**
     * This method overrides the hashCode function and returns a new hash code
     *
     * Code is adapted from "How to Implement Java’s hashCode Correctly"
     * By Nicolai Parlog
     * Published May 19, 2016, Updated November 7, 2024
     * https://www.sitepoint.com/how-to-implement-javas-hashcode-correctly/
     *
     * @return
     *   A unique hash code as an integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}