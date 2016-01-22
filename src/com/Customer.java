package com;


import com.coffee.Coffee;
import com.coffee.packed.InstantCoffee;
import com.coffee.scatter.ScatterCoffee;

import java.util.ArrayList;

/**
 * Class {@code Customer}. It sets the value of coffee, money, volume
 *
 * @author dog
 * @version 1.1
 */
public class Customer {
    /* parameter determines the amount of money */
    private double money;
    /* parameter specifies the volume */
    private double volume;
    /* parameter specifies the list of objects coffee */
    ArrayList<Coffee> coffees = new ArrayList<Coffee>() {
        {
            add(new ScatterCoffee(ScatterCoffee.Scatter.COFFEE_BEANS, Coffee.Country.UKRAINE, Coffee.Sort.FIRST, 11));
            add(new ScatterCoffee(ScatterCoffee.Scatter.COFFEE_BEANS, Coffee.Country.CHINA, Coffee.Sort.FIRST, 10));
            add(new ScatterCoffee(ScatterCoffee.Scatter.GROUND_COFFEE, Coffee.Country.MOLDOVA, Coffee.Sort.FIRST, 9));
            add(new InstantCoffee(InstantCoffee.Instant.COFFEE_IN_BAGS, Coffee.Country.UKRAINE, Coffee.Sort.FIRST, 8));
            add(new InstantCoffee(InstantCoffee.Instant.COFFEE_IN_BANK, Coffee.Country.MOLDOVA, Coffee.Sort.THIRD, 5));
        }
    };


    /**
     * Constructor Customer initializes the value of money and volume.
     *
     * @param money
     * @param volume
     */
    public Customer(double money, double volume) {
        checkMoney(money);
        checkVolume(volume);
        this.money = money;
        this.volume = volume;
    }

    /**
     * Method creates an object {@code Worker} that simulates the loading wagon.
     * To sort and search for quality parameters.
     */
    public void calculate() {
        Worker worker = new Worker(this, coffees);
        worker.sortPrice();
        worker.searchCoffee(Coffee.Country.UKRAINE, Coffee.Sort.FIRST);
    }

    /**
     * Method returns value money.
     *
     * @return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * Method sets value money.
     *
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Method returns value volume.
     *
     * @return volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Method sets value money.
     *
     * @param volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }


    /**
     * Method checks for the correct input value money.
     *
     * @param money
     */
    private void checkMoney(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("illegal money number");
        }
    }

    /**
     * Method checks for the correct input value volume.
     *
     * @param volume
     */
    private void checkVolume(double volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("illegal value number");
        }

    }
}
