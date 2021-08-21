import java.util.Scanner;

public class doublyLinkedList {
    Scanner sc = new Scanner(System.in);
    DNode root;

    class DNode {

        DNode left;
        int data;
        DNode right;

        // Constructor
        DNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    // Append function
    void append() {
        System.out.println("Enter element: ");
        int new_data = sc.nextInt();
        DNode temp = new DNode(new_data);
        if (root == null) {
            root = temp;
        } else {
            DNode p = root;

            while (p.right != null) {
                p = p.right;
            }

            temp.left = p;
            p.right = temp;
        }

    }

    // Display function
    void display() {
        if (root == null) {
            System.out.println("List is Empty.");
        }
        DNode p = root;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.right;

        }
        System.out.println("");

    }

    // Length function
    int length() {
        int count = 0;
        if (root == null) {
            System.out.println("List is Empty");
            return count;
        } else {
            DNode p = root;
            while (p != null) {
                count++;
                p = p.right;
            }
        }
        return count;
    }

    // Add at a location
    void addatafter(int ele) {
        System.out.println("Enter location: ");
        int location = sc.nextInt();
        if (location > length()) {
            System.out.println("Enter valid Input");
            return;
        } else if (location == 1) {
            DNode temp = new DNode(ele);
            temp.right = root;
            root.left = temp;
            root = temp;
        } else {
            DNode temp = new DNode(ele);
            DNode p = root;
            DNode q = root;
            while (location-- > 1) {
                p = p.right;

            }

            q = p.right;
            p.right = temp;
            temp.right = q;
            temp.left = p;
        }

    }

    // Deletion
    void delete() {
        System.out.println("Enter location to delete");
        int loc = sc.nextInt();
        if (root == null) {
            System.out.println("List is Empty.");
            return;
        } else if (loc > length()) {
            System.out.println("Enter a valid input. Length is " + length());
            return;
        } else if (loc == 1) {
            DNode temp = root;
            root = root.right;
            root.right.left = null;
            temp.right = null;
        } else {
            DNode p = root; // for node before the node to be deleted
            DNode q = root; // node to be deleted
            while (loc-- > 1) {
                q = q.right;
            }
            p = q.left;
            p.right = q.right;
            q.right.left = p; // q.right.left is the node after the node to be deleted

            q.left = null;
            q.right = null;
        }
    }

    public static void main(String[] args) {
        doublyLinkedList obj = new doublyLinkedList();
        // obj.append(1);
        // obj.append(2);
        // obj.append(3);
        // obj.append(4);
        // obj.display();
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a choice ");
            System.out.println("1.Append");
            System.out.println("2.Display");
            System.out.println("3.Length");
            System.out.println("4.Delete");
            System.out.println("5.Exit");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    obj.append();
                    break;
                case 2:
                    obj.display();
                    break;
                case 3:
                    obj.length();
                    break;
                case 4:
                    obj.delete();
                    break;
                case 5:
                    System.exit(0);
                    scn.close();
                    break;

                default:
                    System.out.println("Enter valid input");
                    break;
            }

        }

    }

}
