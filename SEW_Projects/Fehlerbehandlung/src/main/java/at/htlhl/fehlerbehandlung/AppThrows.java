package at.htlhl.fehlerbehandlung;

/**
 * Fehlerbehandlung mit throw and thorws
 */

public class AppThrows {
    protected int squareAdvanced(int value, int lowerBound, int upperBound) throws SquareException {
        if (value < lowerBound || value > upperBound) {
            throw new SquareException("Out of bounds");
        }
        return value*value;
    }

    public static void main(String[] args) {
        AppThrows appThrows = new AppThrows();
        try {
            int squared = appThrows.squareAdvanced(5, 2, 25);
            System.out.println("Squared value: " + squared);
        } catch (SquareException ex) {
            System.err.println("SquaredException: " + ex.getMessage());
        }
    }
}
