package service;

public class FineCalculator {

    public static final double FINE_PER_DAY = 2.0;

    // Calculate fine based on number of late days
    public double calculateFine(int daysLate) {

        if (daysLate <= 0) {
            return 0.0;
        }

        double fine = daysLate * FINE_PER_DAY;

        return fine;
    }

    // Type casting example
    public int getRoundedFine(double fine) {
        return (int) fine;
    }
}