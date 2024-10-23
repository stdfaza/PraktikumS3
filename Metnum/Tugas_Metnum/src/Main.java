public class Main {
    // Fungsi f(x) = x^2 - x - 2
    static double f(double x) {
        return x * x - x - 2;
    }
    static void regulaFalsi(double x1, double x2, double tolerance) {
        double xr = x1;
        double prev_xr;
        int iteration = 0;

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Iterasi", "a", "b", "x", "f(a)", "f(b)", "f(x)");
        do {
            prev_xr = xr;
            xr = x1 - (f(x1) * (x2 - x1)) / (f(x2) - f(x1));

            System.out.printf("%-10d %-10.5f %-10.5f %-10.5f %-10.5f %-10.5f %-10.5f\n",
                    iteration, x1, x2, xr, f(x1), f(x2), f(xr));

            if (f(x1) * f(xr) < 0) {
                x2 = xr;
            } else {
                x1 = xr;
            }

            iteration++;
        } while (Math.abs(xr - prev_xr) > tolerance);

        System.out.printf("\nAkar yang ditemukan: %.5f\n", xr);
    }

    public static void main(String[] args) {
        double x1 = 1;
        double x2 = 3;
        double tolerance = 0.00001;

        regulaFalsi(x1, x2, tolerance);
    }
}
