package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "Northwest Territories");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(c);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City c = new City("Charlottetown", "Prince Edward Island");
        cityList.add(c);
        assertEquals(0, c.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City edmonton = mockCity();
        City yellowKnife = new City("Yellowknife", "Northwest Territories");
        assertEquals(true, mockCityList().hasCity(edmonton));
        assertEquals(false, mockCityList().hasCity(yellowKnife));
    }

    @Test
    void testDeleteCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City yellowKnife = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(yellowKnife);
        });
        City edmonton = mockCity();
        cityList.deleteCity(edmonton);
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City yellowKnife = new City("Yellowknife", "Northwest Territories");
        cityList.add(yellowKnife);
        assertEquals(2, cityList.countCities());
    }

}