import java.util.Scanner;



public class circularLinkedList {
    CNode root;

    class CNode {

        int data;
        CNode next;

        // Constructor
        CNode(int d) {
            data = d;
            next = null;
        }
    }

    // Add at last
    void append(int ele) {
        if (root == null) {
            CNode temp = new CNode(ele);
            root = temp;
            temp.next = root;

        } else {
            CNode temp = new CNode(ele);
            CNode p = root;
            CNode ptr = root.next;
            while (ptr.next != root) {
                ptr = ptr.next;
            }
            ptr.next = temp;
            temp.next = p;

        }
    }

    // Insert at a location
    void addatafter(int ele) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter location: ");
        int loc = sc.nextInt();
        CNode temp = new CNode(ele);
        if (loc == 1) {

            CNode p = root;
            while (p.next != root) {
                p = p.next;
            }
            temp.next = root;
            root = temp;
            p.next = root;
            sc.close();
            return;
        } else {
            CNode p = root; // if the location of the node to be added is 3 then p=2 and q=3
            CNode q = root;
            while (--loc > 1) {
                p = p.next;
            }
            q = p.next;
            temp.next = q;
            p.next = temp;
        }
        sc.close();

    }

    // Delete FUnction
    void delete(int loc) {

        if (root == null) {
            return;
        }
        // If head needs to be removed
        if (loc == 1) {
            root = root.next; // Change head
            return;
        } else if (length() >= loc) {
            CNode p = root;
            CNode q = root;

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

    // Display Function
    void display() {

        if (root == null) {
            System.out.println("List is Empty");
            return;
        }
        CNode p = root;

        do {
            System.out.print(p.data + "->");
            p = p.next;
        } while (p != root);
        System.out.println("");
    }

    // Length Function
    int length() {
        int count = 0;
        if (root == null) {
            System.out.println("List is Empty");
            return count;
        }
        CNode p = root;

        do {
            System.out.print(p.data + "->");
            p = p.next;
            count++;
        } while (p != root);
        System.out.println("");
        return count;
    }

    // Driver Code
    public static void main(String[] args) {
        circularLinkedList list = new circularLinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.display();
        list.addatafter(6);
        list.display();
        int len = list.length();
        System.out.println("length " + len);
        list.delete(4);
        list.display();
    }

}
