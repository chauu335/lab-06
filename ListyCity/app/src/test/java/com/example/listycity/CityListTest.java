package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;
import org.junit.Test;

public class CityListTest {
    @NonNull
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @NonNull
    @Contract(value = " -> new", pure = true)
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City c = new City("Regina", "SK");
        cityList.add(c);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(c));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(c);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0))); // Assert correct initialization
        City c = new City("Charlottetown", "PEI");
        cityList.add(c);
        assertEquals(0, c.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();     // Initialize a class of container with mock city (Edmonton, AB)
        assertTrue(cityList.hasCity(mockCity()));
        City c = new City("Calgary", "AB");
        assertFalse(cityList.hasCity(c));
        assertFalse(cityList.hasCity(null));
        assertFalse(cityList.hasCity(new City("edmonton", "ab")));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Calgary", "AB"));
        });
        cityList.delete(mockCity());
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(mockCity()));
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City c = new City("Vancouver", "BC");
        cityList.add(c);
        assertEquals(2, cityList.countCities());
    }
}
