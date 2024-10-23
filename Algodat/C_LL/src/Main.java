
class Node{
    int data;
    Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
}
class Cll{
    public Node head;
    public Node tail;

    public Cll(){
        this.head = null;
        this.tail = null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

    }
    public void del(int data){
        if (head == null){
            System.out.println("Kosong");
            return;
        }
        Node current = head;
        Node prev = null;
        do{
            if(current.data == data){
                if(current == head){
                    head = head.next;
                    tail.next =head;
                }else if(current == tail){
                    tail = prev;
                    tail.next = head;
                }else{
                    prev.next = current.next;
                }System.out.println(+ data + " telah dihapus");
                return;
            }prev = current;
            current = current.next;
        }while(current != head);
    }
    public void display(){
        if(head == null){
            System.out.println("Kosong");
            return;
        }
        Node current = head;
        System.out.println("CLL\n");
        do{
            System.out.println(current.data + " ");
            current = current.next;
        }while(current!=head);
        System.out.println();
    }
    public static void main(String[] arg){
        Cll list = new Cll();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display();

        list.del(20);
        list.display();

        list.del(50);
    }
}