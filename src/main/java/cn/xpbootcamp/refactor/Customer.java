package cn.xpbootcamp.refactor;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        for (Rental rental : this.rentals) {
            //show figures for this rental
            //determine amounts for rental line
            double thisAmount = 0d;
            switch (rental.getMovie().getPriceCode()) {
                case Movie.HISTORY:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CAMPUS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }
            //add frequent renter points
            frequentRenterPoints++;
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
