import java.util.Scanner;

class Order {
    String customerName;
    int tableNumber;
    String foodName;
    Order next;

    public Order(String customerName, int tableNumber, String foodName) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.foodName = foodName;
        this.next = null;
    }
}

class OrderList {
    private Order head;

    public OrderList() {
        this.head = null;
    }

    // Untuk Menambahkan pesanan baru
    public void addOrder(String customerName, int tableNumber, String foodName) {
        Order newOrder = new Order(customerName, tableNumber, foodName);
        if (head == null) {
            head = newOrder;
        } else {
            Order temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newOrder;
        }
        System.out.println("Pesanan ditambahkan: " + foodName + " untuk " + customerName + " di meja " + tableNumber);
    }

    // Untuk Menghapus pesanan yang sudah selesai (FIFO - First In, First Out)
    public void removeOrder() {
        if (head == null) {
            System.out.println("Tidak ada pesanan untuk dihapus.");
            return;
        }
        System.out.println("Pesanan selesai: " + head.foodName + " untuk " + head.customerName + " di meja " + head.tableNumber);
        head = head.next;
    }

    // Untuk Menampilkan daftar pesanan
    public void displayOrders() {
        if (head == null) {
            System.out.println("Tidak ada pesanan saat ini.");
            return;
        }
        Order temp = head;
        System.out.println("Daftar Pesanan:");
        while (temp != null) {
            System.out.println("Nama: " + temp.customerName + ", Meja: " + temp.tableNumber + ", Makanan: " + temp.foodName);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderList orderList = new OrderList();
        int choice;

        do {
            System.out.println("\n=== Menu Pesanan ===");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Hapus Pesanan");
            System.out.println("3. Tampilkan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Masukkan nomor meja: ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Masukkan nama makanan: ");
                    String foodName = scanner.nextLine();
                    orderList.addOrder(customerName, tableNumber, foodName);
                    break;

                case 2:
                    orderList.removeOrder();
                    break;

                case 3:
                    orderList.displayOrders();
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
