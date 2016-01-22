package com.coffee;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class {@code Coffee}. It has parameter coffee
 * @author dog
 * @version 1.1
 */
public abstract class Coffee {
    /* class enum determines quality parameter - sort of coffee */
    public enum Sort{FIRST, SECOND, THIRD}
    /* class enum determines quality parameter - producing country */
    public enum Country{UKRAINE, CHINA, MOLDOVA}
    /* parameter - price*/
    protected double price;
    /* quality parameter - sort of coffee */
    private Sort sort;
    /* quality parameter - producing country */
    private Country country;

    /**
     * Constructor creates an object {@code Coffee} and initializes quality parameters.
     * @param country quality parameter.
     * @param sort quality parameter.
     */
    public Coffee(Country country, Sort sort){
        this.country = country;
        this.sort = sort;
    }

    /**
     * Method returns a cost of coffee.
     * @return cost of coffee.
     */
    public abstract double getCost();

    /**
     * Method returns a volume of coffee.
     * @return volume of coffee.
     */
    public abstract double getVolume();

    /**
     * Method returns a weight of coffee.
     * @return weight of coffee.
     */
    public abstract double getWeight();


    /**
     * Method returns a sort of coffee.
     * @return sort of coffee.
     */
    public Sort getSort() {
        return sort;
    }

    /**
     * Method returns a producing country of coffee.
     * @return producing country.
     */
    public Country getCountry() {
        return country;
    }


    /**
     * Method determines the price of coffee depending on the quality parameters
     * @param type type of coffee
     * @return price of coffee
     */
    protected double definePrice(String type){
        try {
            return (Double) new JSONObject(new String(Files.readAllBytes(Paths.get("src/file.json"))))
                    .get(type + " " + getCountry().toString() + " " + getSort().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
