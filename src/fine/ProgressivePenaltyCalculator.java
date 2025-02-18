package fine;

public class ProgressivePenaltyCalculator implements PenaltyCalculator {

    @Override
    public double calculateFine(long overdueDays) {
        return overdueDays <= 5 ? overdueDays * 1.5 : (5 * 1.5) + ((overdueDays - 5) * 3.0);
    }
}
