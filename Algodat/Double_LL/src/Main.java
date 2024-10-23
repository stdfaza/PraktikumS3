class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public void tambah(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void kedepan(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        if (temp != null && temp.data == data) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println(data + " not found in the list.");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();


        dll.tambah(10);
        dll.tambah(20);
        dll.tambah(30);

        dll.kedepan(5);
        dll.kedepan(1);

        System.out.print("Current List: ");
        dll.display();  // Output: 1 5 10 20 30

        dll.delete(10);
        System.out.print("After Deleting 10: ");
        dll.display();  // Output: 1 5 20 30

        dll.delete(100);  // Output: 100 not found in the list.
    }
}
