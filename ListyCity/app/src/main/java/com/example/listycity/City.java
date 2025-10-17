package com.example.listycity;

import androidx.annotation.Nullable;

import java.util.Objects;

/**
 * This is a class that defines a City
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
     * This method compares cities based on city name field
     * @return -1 if caller is greater than the city name field
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City c = (City) obj;
        return Objects.equals(city, c.getCityName()) && Objects.equals(province, c.getProvinceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
