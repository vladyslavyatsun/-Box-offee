package com.coffee.packed;

import com.coffee.Coffee;

/**
 * Class {@code InstantCoffee} extends class {@code Coffee} and has parameters of instant coffee.
 *
 * @author dog
 * @version 1.1
 */
public class InstantCoffee extends Coffee {
    /**
     * Class enum determines kind of instant coffee
     */
    public enum Instant {
        /* object coffee in bags */
        COFFEE_IN_BAGS(0.02, 1),
        /* object coffee in bank*/
        COFFEE_IN_BANK(0.03, 1);
        /*parameter volume of coffee*/
        private double volume;
        /*parameter weight of coffee*/
        private double weight;

        /**
         * Constructor initializes parameters of coffee
         *
         * @param volume
         * @param weight
         */
        Instant(double volume, double weight) {
            this.volume = volume;
            this.weight = weight;
        }

        public double getVolume() {
            return volume;
        }

        public double getWeight() {
            return weight;
        }
    }

    /* kind of instant coffee */
    Instant type;
    /* parameter bank or bags number of coffee */
    protected int number;

    /**
     * Constructor creates an object {@code InstantCoffee} and initializes type of coffee,
     * quality parameters and parameter number of coffee.
     *
     * @param type    type of coffee.
     * @param country quality parameter.
     * @param sort    quality parameter.
     * @param number  number of coffee.
     */
    public InstantCoffee(Instant type, Country country, Sort sort, int number) {
        super(country, sort);
        checkNumber(number);
        this.number = number;
        this.type = type;
        price = definePrice(type.toString());
    }

    @Override
    public double getVolume() {
        return type.getVolume();
    }

    @Override
    public double getCost() {
        return price * number;
    }

    @Override
    public double getWeight() {
        return type.getWeight() * number;
    }

    @Override
    public String toString() {
        return type.toString() + ", " + getCountry().toString() + ", " + getSort().toString() + ": " + price;
    }

    /**
     * Method checks for the correct input value number.
     *
     * @param number
     */
    private void checkNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("number is negative");
        }
    }
}
