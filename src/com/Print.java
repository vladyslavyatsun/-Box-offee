package com;

import com.coffee.Coffee;

import java.util.List;

/**
 * Class {@code Print}. It has methods that print information about coffee.
 */
public class Print {
    /**
     * Method prints information about selected coffee.
     *
     * @param coffee
     */
    public void print(Coffee coffee) {
        System.out.println("\nget coffee:");
        System.out.println(coffee.toString());
    }

    /**
     * Method prints information about selected list coffee.
     *
     * @param coffeeList
     */
    public void print(List<Coffee> coffeeList) {
        System.out.println("Sort price:");
        for (Coffee coffee : coffeeList) {
            System.out.println(coffee.toString());
        }
    }
}
