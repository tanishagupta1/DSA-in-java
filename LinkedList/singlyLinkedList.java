import java.util.Scanner;

class singlyLinkedList {
    Node root;

    // Like the structure in c language
    class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            next = null;
            data = d;
        }
    }

    // Append Function
    public void append(int new_data) {

        if (root == null) {
            root = new Node(new_data);
            return;
        }

        // Created a new node
        Node new_node = new Node(new_data);
        // new_node.next=null;
        Node p = root;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new_node;
        return;
    }

    void addatafter(int ele) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter location: ");
        int location = sc.nextInt();

        if (location > length()) {
            System.out.println("Enter valid Input");
            sc.close();
            return;
        } else if (location == 1) {
            Node temp = new Node(ele);
            temp.next = root;
            root = temp;
        } else {
            Node temp = new Node(ele);
            Node p = root;
            Node q = root;
            for (int i = 1; i < location; i++) {
                p = p.next;
            }
            // q is used to get the previous node
            for (int j = 1; j < location - 1; j++) {
                q = q.next;
            }

            temp.next = p;
            q.next = temp;

        }
      sc.close();
    }

    // Display Function
    public void display() {
        Node p = root;
        // no new node is created here
        if (root == null) {

            System.out.println("List is Empty");
        } else {
            while (p != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
        }
        System.out.println("");
    }

    // Length Function
    public int length() {
        int count = 0;
        Node p = root;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;

    }

    // Reverse Function
    // We have changed the data in the nodes
    public void reverseData() {
        System.out.println("Reversing the data...");
        int i = 0;
        int j = 0;
        int k;
        // k is helping to iterate q
        Node p = root;
        Node q = root;
        int temp = 0;
        j = length() - 1;
        while (i < j) {
            // K is initialized again with zero as q will again start iterating from root
            k = 0;
            while (k < j) {
                q = q.next;
                k++;
            }
            temp = p.data;
            p.data = q.data;
            q.data = temp;
            i++;
            j--;
            p = p.next;
            q = root;
        }

    }

    // Reverse iterative and faster
    // Here we reverse the nodes
    public void reverseIterative() {
        Node current = root;
        Node previous = null;
        Node ahead = null;
        while (current != null) {
            ahead = current.next;
            current.next = previous;
            previous = current;
            current = ahead;

        }
        // as the first node is now the previous node
        root = previous;

    }

    // sorting
    void countSort() {
        int[] count = new int[10];
        Node p = root;
        while (p != null) {
            count[p.data]++;
            p = p.next;
        }
        int i = 0;
        // This is only used for the list of single digits numbers
        p = root;
        while (p.next != null) {
            if (count[i] == 0) {
                i++;
            } else {
                p.data = i;
                --count[i];
                p = p.next;
            }
        }
    }

    // Delete function
    void delete(int loc) {

        System.out.println("length" + length());
        if (root == null) {
            return;
        }
        // If head needs to be removed
        if (loc == 1) {
            root = root.next; // Change head
            return;
        }
        if (length() >= loc) {
            Node p = null;
            Node q = null;
            p = root;
            q = root;
            for (int i = 1; i < loc; i++) {
                p = p.next;
            }
            // q is used to get the previous node
            for (int j = 1; j < loc - 1; j++) {
                q = q.next;
            }
            q.next = p.next;
            p.next = null;

        }
    }

    public static void main(String[] args) {
        singlyLinkedList list1 = new singlyLinkedList();

        list1.append(10);
        list1.append(2);
        list1.append(30);
        list1.append(40);
        list1.append(50);
        list1.display();

        list1.addatafter(5);
        list1.display();

        // REVERSE FUNCTION
        // list1.reverseData();
        // list1.display();
        list1.reverseIterative();
        list1.display();

        // Sorting using count sort
        // list1.countSort();
        // list1.display();

        // Delete Implementation
        list1.delete(6);
        list1.display();

        // Length Implementation
        // int len = list1.length();
        // System.out.println("The length of nodes is " + len);

    }

}