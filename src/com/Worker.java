package com;


import com.coffee.Coffee;

import java.util.Comparator;
import java.util.List;

/**
 * Class {@code Worker} performs the loading wagon. Class has methods sort and search.
 *
 * @author dog
 * @version 1.1
 */
public class Worker {
    /* the object printing results */
    private Print print = new Print();
    /* object customer */
    private Customer customer;
    /* the list of objects coffee */
    private List<Coffee> coffees;

    /**
     * Constructor {@code Worker} initializes the value of customer, coffees and starts method loadVan();
     *
     * @param customer
     * @param coffees
     */
    public Worker(Customer customer, List<Coffee> coffees) {
        this.customer = customer;
        this.coffees = coffees;
        loadVan();
    }

    /**
     * Method simulates the loading van and reduces the amount of money and options
     */
    private void loadVan() {
        for (Coffee coffee : coffees) {
            customer.setMoney(customer.getMoney() - coffee.getCost());
            customer.setVolume(customer.getVolume() - coffee.getVolume());
        }

        checkMoney(customer.getMoney());
        checkVolume(customer.getVolume());
    }

    /**
     * Method sorts of coffee in terms of price-to-weight
     */
    public void sortPrice() {
        coffees.sort(new Comparator<Coffee>() {
            @Override
            public int compare(Coffee o1, Coffee o2) {
                if (o1.getCost() / o1.getWeight() < o2.getCost() / o2.getWeight()) {
                    return 1;
                }
                return -1;
            }
        });
        print.print(coffees);
    }

    /**
     * Method of searching coffee
     *
     * @param country quality parameter
     */
    public void searchCoffee(Coffee.Country country) {
        for (Coffee coffee : coffees) {
            if (coffee.getCountry() == country) {
                print.print(coffee);
            }
        }
    }

    /**
     * Method of searching coffee
     *
     * @param sort quality parameter
     */
    public void searchCoffee(Coffee.Sort sort) {
        for (Coffee coffee : coffees) {
            if (coffee.getSort() == sort) {
                print.print(coffee);
            }
        }
    }

    /**
     * Method of searching coffee
     *
     * @param country quality parameter
     * @param sort    quality parameter
     */
    public void searchCoffee(Coffee.Country country, Coffee.Sort sort) {
        for (Coffee coffee : coffees) {
            if (coffee.getCountry() == country && coffee.getSort() == sort) {
                print.print(coffee);
            }
        }
    }

    /**
     * Method checks enough money
     *
     * @param money
     */
    private void checkMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("You not have enough money. You are missing " + Math.abs(money));
        } else {
            System.out.println("You have enough money. Your change " + money);
        }
    }

    /**
     * Method checks enough volume
     *
     * @param volume
     */
    private void checkVolume(double volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("You not have enough volume. You are missing " + Math.abs(volume));
        } else {
            System.out.println("You have enough volume. You still have " + volume);
        }
    }


}
