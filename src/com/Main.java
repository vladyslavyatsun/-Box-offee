package com;

/**
 * The main class of the program.
 *
 * @author dog
 * @version 1.1
 */
public class Main {
    /**
     * Method creates an object and begins the calculus
     *
     * @param args parameter of command line
     */
    public static void main(String[] args) {
        Customer customer = new Customer(4000, 2);
        customer.calculate();

    }
}
