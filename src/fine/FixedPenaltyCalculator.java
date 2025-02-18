package fine;

public class FixedPenaltyCalculator implements PenaltyCalculator {

    @Override
    public double calculateFine(long overdueDays) {
        return overdueDays * 2.0;
    }
}
