package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds city type objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a City type object to the cities list
     * @param c: the object to add
     * @throws : IllegalArgumentException if c already exists in the list
     */
    public void add(City c) {
        if (cities.contains(c)) {
            throw new IllegalArgumentException();
        }
        cities.add(c);
    }

    /**
     * This method returns a sorted list of all cities in the collection
     * @return a sorted list of cities in ascending order
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if a city is present in the cities list
     * @param c: the city object to check if is contained in the cities list
     * @return : true if the city is in the cities list
     */
    public boolean hasCity(City c) {
        if (c == null) return false;
        return cities.contains(c);
    }

    /**
     * This method checks if a city is present in the cities list
     * and remove it from the list if true
     * @param c: the city to delete
     * @throws : IllegalArgumentException if c is not in the list
     */
    public void delete(City c) {
        if (!hasCity(c)) throw new IllegalArgumentException();
        cities.remove(c);
    }

    /**
     * This method returns how many cities are there in the cities list
     * @return the number of cities in the cities list
     */
    public int countCities() {
        return cities.size();
    }
}
