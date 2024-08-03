package cn.xpbootcamp.refactor;

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
        return this.rentals.stream().mapToDouble(Customer::getRowAmount).sum();
    }

    private StringBuilder renderRow() {
        return this.rentals.stream().map(this::buildRow).reduce(new StringBuilder(), StringBuilder::append);
    }

    private int getFrequentRenterPoints() {
        return this.rentals.stream().mapToInt(Rental::getAddPoint).sum();
    }

    private StringBuilder buildRow(Rental rental) {
        StringBuilder row = new StringBuilder();
        row.append("\t")
                .append(rental.getMovie().getTitle())
                .append("\t")
                .append(getRowAmount(rental)).append("\n");
        return row;
    }

    private static double getRowAmount(Rental rental) {
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
        return thisAmount;
    }

}
