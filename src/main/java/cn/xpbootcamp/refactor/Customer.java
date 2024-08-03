package cn.xpbootcamp.refactor;

import java.util.Vector;

public class Customer {

    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

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
        return "Rental Record for " + getName() + "：\n" + renderRow() +
                buildFooter(getTotalAmount(), getFrequentRenterPoints());
    }

    private static StringBuilder buildFooter(double totalAmount, int frequentRenterPoints) {
        StringBuilder footer = new StringBuilder();
        footer.append("Amount owed is ").append(totalAmount).append("\n");
        footer.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return footer;
    }

    private double getTotalAmount() {
        return this.rentals.stream().mapToDouble(Rental::getRowAmount).sum();
    }

    private StringBuilder renderRow() {
        return this.rentals.stream().map(Rental::buildRow).reduce(new StringBuilder(), StringBuilder::append);
    }

    private int getFrequentRenterPoints() {
        return this.rentals.stream().mapToInt(Rental::getAddPoint).sum();
    }

}
