import java.util.Random;  // Tambahkan ini untuk menggunakan kelas Random

public class Main {

    // Fungsi untuk menampilkan matriks
    static void showMatrix(double[][] matrix, int rowCount, int colCount) {
        for (int r = 0; r < rowCount; ++r) {
            for (int c = 0; c < colCount; ++c) {
                System.out.printf("%06.2f, ", matrix[r][c]);
            }
            System.out.println();  // Newline after every row
        }
        System.out.println("------------------------------------");  // Separator for readability
    }

    // Fungsi eliminasi Gauss-Jordan
    static double[][] gaussJordan(double[][] matrix, int rowCount, int colCount) {
        for (int i = 0; i < rowCount; ++i) {
            // Normalisasi elemen diagonal ke 1
            double diagValue = matrix[i][i];
            for (int j = 0; j < colCount; ++j) {
                matrix[i][j] /= diagValue;
            }

            // Ubah elemen di atas dan di bawah diagonal menjadi 0
            for (int k = 0; k < rowCount; ++k) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j < colCount; ++j) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }
        return matrix;
    }

    // Generate random matrix A
    static double[][] generateRandomMatrix(int size) {
        Random rand = new Random();  // Menggunakan kelas Random dari java.util
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix[i][j] = rand.nextDouble() * 10;  // Matriks random dengan elemen antara 0-10
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int size = 10;
        double[][] A = generateRandomMatrix(size);

        // Vektor b = [1, 0, 0, 0, v, 0, 0, 0, 0, -1] dengan v = 6 (digit terakhir NIM 126)
        double[] b = {1, 0, 0, 0, 6, 0, 0, 0, 0, -1};

        // Membuat matriks augmented A|b
        double[][] aug = new double[size][size + 1];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                aug[i][j] = A[i][j];
            }
            aug[i][size] = b[i];  // Menambah kolom vektor b ke matriks augmented
        }

        // Tampilkan Matrix A augmented B sebelum eliminasi
        System.out.println("Matrix A augmented B Sebelum eliminasi Gauss-Jordan:");
        showMatrix(aug, size, size + 1);

        // Proses eliminasi Gauss-Jordan
        aug = gaussJordan(aug, size, size + 1);

        // Tampilkan Matrix A augmented B setelah eliminasi
        System.out.println("Matrix A augmented B Setelah eliminasi Gauss-Jordan:");
        showMatrix(aug, size, size + 1);
    }
}