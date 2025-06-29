public class FinancialForecast {

    // Recursive function to calculate future value
    public static double futureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return futureValue(principal, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double initialAmount = 10000;   // ₹10,000
        double annualGrowthRate = 0.05; // 5% growth
        int numYears = 5;

        double futureVal = futureValue(initialAmount, annualGrowthRate, numYears);

        System.out.printf("Future value after %d years: ₹%.2f%n", numYears, futureVal);
    }
}
