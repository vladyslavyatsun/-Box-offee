package com.coffee.scatter;

import com.coffee.Coffee;

/**
 * Class {@code ScatterCoffee} extends class {@code Coffee} and has parameters of scatter coffee.
 *
 * @author dog
 * @version 1.1
 */
public class ScatterCoffee extends Coffee {
    /**
     * Class enum {@code Scatter} determines kind of scatter coffee
     */
    public enum Scatter {
        /* object coffee beans */
        COFFEE_BEANS(110.0),
        /* object ground coffee */
        GROUND_COFFEE(111.1);

        /*parameter density of coffee*/
        private double density;

        /**
         * Constructor initializes parameter of coffee
         *
         * @param density
         */
        Scatter(double density) {
            this.density = density;
        }

        public double getDensity() {
            return density;
        }
    }

    ;

    /* kind of scatter coffee */
    Scatter type;
    /* parameter weight of coffee*/
    private double weight;

    /**
     * Constructor creates an object {@code ScatterCoffee} and initializes type of coffee,
     * quality parameters and parameter weight of coffee.
     *
     * @param type    type of coffee.
     * @param country quality parameter.
     * @param sort    quality parameter.
     * @param weight  weight of coffee.
     */
    public ScatterCoffee(Scatter type, Country country, Sort sort, double weight) {
        super(country, sort);
        checkWeight(weight);
        this.weight = weight;
        this.type = type;
        price = definePrice(type.toString());
    }


    @Override
    public double getCost() {
        return price * weight;
    }

    @Override
    public double getVolume() {
        return weight / type.getDensity();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return type.toString() + ", " + getCountry().toString() + ", " + getSort().toString() + ": " + price;
    }

    /**
     * Method checks for the correct input value weight.
     *
     * @param weight
     */
    private void checkWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("weight is negative");
        }
    }

}
