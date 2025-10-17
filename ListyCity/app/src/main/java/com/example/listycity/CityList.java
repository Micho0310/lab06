package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city to the list if the city does not already exist
     * @param city
     *   This is the city to add to the list
     * @throws
     * IllegalArgumentException if the city is already in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This method sorts and returns the list of cities
     * @return
     *    Returns the sorted city list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if a city is in the list
     * @param city
     *    This is the city to check
     * @return
     *    A boolean true or false depending on if the city is in the list
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * This method deletes a city from the list of cities
     * @param city
     *   The city to be deleted from the list
     */
    public void deleteCity(City city) {
        if (this.cities.contains(city)) {
            this.cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method returns the number of cities in the city list
     * @return
     *   How many cities are in the list
     */
    public int countCities() {
        return this.cities.size();
    }
}
