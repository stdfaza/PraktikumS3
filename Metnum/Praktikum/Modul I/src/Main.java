import java.util.Scanner;
import java.lang.Math;

public class Main {

    // Fungsi f(x)
    public static double f(double x) {
        return Math.pow(x, 2) - 2 * x + 1 - (Math.pow(x, 3) - (x + 2) * Math.exp(-2 * x) + 1);
    }

    // Bisection method dengan tabel iterasi
    public static double bisection(double a, double b, double tol) {
        int iterasi = 0;

        // Print header untuk tabel
        System.out.printf("\nToleransi: %.1e\n", tol);
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Iterasi", "a", "b", "x", "f(x)", "f(a)", "|b - a|");

        // Lakukan iterasi sampai nilai batas selisih lebih kecil dari toleransi
        while (Math.abs(b - a) > tol) {
            double mid = (a + b) / 2;
            iterasi++;

            // Print nilai iterasi, a, b, mid, f(mid), f(a), dan |b - a|
            System.out.printf("%-10d%-15f%-15f%-15f%-15f%-15f%-15f\n", iterasi, a, b, mid, f(mid), f(a), Math.abs(b - a));

            if (f(mid) == 0) { // Jika mid tepat adalah akar
                return mid;
            } else if (f(a) * f(mid) < 0) { // Akar berada di antara a dan mid
                b = mid;
            } else { // Akar berada di antara mid dan b
                a = mid;
            }
        }
        return (a + b) / 2; // Kembalikan akar dengan pendekatan interval akhir
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input dari pengguna
        System.out.print("Masukkan batas bawah (a): ");
        double a = input.nextDouble();

        System.out.print("Masukkan batas atas (b): ");
        double b = input.nextDouble();

        // Pastikan f(a) dan f(b) memiliki tanda yang berbeda
        if (f(a) * f(b) >= 0) {
            System.out.println("Batas tidak valid, pastikan f(a) dan f(b) memiliki tanda berbeda.");
        } else {
            // Jalankan metode bisection untuk 3 toleransi berbeda
            double[] tolerances = {1e-4, 1e-6, 1e-12};

            for (double tolerance : tolerances) {
                // Jalankan bisection untuk setiap toleransi dan tampilkan tabel iterasi
                double root = bisection(a, b, tolerance);
                System.out.println("Titik potong ditemukan di x = " + root);
            }
        }

        input.close();
    }
}
