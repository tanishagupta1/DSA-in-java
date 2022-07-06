import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class binarytreeconstruct {
    // Node for Binary Tree
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class construct {
        Node root;

        construct() {
            root = null;
        }

        construct(int val) {
            root = new Node(val, null, null);
        }
    }

    // Recursive methods
    // Time Complexity of preOrder is O(n) where n is the numbe of nodes Space
    // complexity : O(n)
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ->");
        preOrder(node.left);
        preOrder(node.right);

    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + "-> ");
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "-> ");
    }

    static List<Integer> iterativeInorder(Node root) {
        Node node = root;
        Stack<Node> st = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                arr.add(node.data);
                node = node.right;
            }
        }
        return arr;
    }

    // iterative postorder
    static List<Integer> iterativePostOrder(Node root) {

        List<Integer> arr = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node node = root;
        st1.push(node);
        while (!st1.isEmpty()) {
            node = st1.pop();
            st2.push(node);
            if (node != null) {
                if (node.left != null)
                    st1.push(node.left);
                if (node.right != null)
                    st1.push(node.right);
            }
        }
        while (!st2.isEmpty()) {
            arr.add(st2.pop().data);
        }

        return arr;
    }
    //iterative post order using one stack
    static List<Integer> itpostonestack(Node root){
        
        Stack<Node> st = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        if(root==null){
            return arr;
        }
        Node curr = root;
        while(curr!=null || !st.isEmpty()){

        if(curr!=null){
            st.push(curr);
            curr = curr.left;
        }
        else{
            Node temp = st.peek().right;
            if(temp==null){
                temp =  st.pop();
                arr.add(temp.data);
                while(!st.isEmpty() && st.peek().right==temp){
                 temp = st.peek();
                 st.pop();
                 arr.add(temp.data);
                }

            }
            else{
                curr = temp;
            }
        }
        }
        return arr;
       
    }

    // Iterative dfs methods
    static List<Integer> iterativepreOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            // although pre order means root left right we
            // will add right first and then left since Stack is a LIFO data structure
            Node t = st.pop();
            ans.add(t.data);
            if (t.right != null) {
                st.push(t.right);
            }
            if (t.left != null) {
                st.push(t.left);
            }
        }
        return ans;
    }

    // level order
    static List<List<Integer>> bfs(Node node) {
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) {
            ans.add(new ArrayList<>());
            return ans;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (q.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            int len = q.size();
            // len denotes the number of nodes present in a level
            for (int i = 0; i < len; i++) {
                Node t = q.remove();
                temp.add(t.data);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        construct tree = new construct();
        tree.root = new Node(1, null, null);
        tree.root.left = new Node(2, null, null);
        tree.root.right = new Node(3, null, null);
        tree.root.left.left = new Node(4, null, null);
        tree.root.left.right = new Node(5, null, null);
        tree.root.left.right.left = new Node(6, null, null);
        tree.root.left.right.right = new Node(7, null, null);

        // PreOrder
        System.out.println("Preorder: ");
        preOrder(tree.root);
        // Inorder
        System.out.println();
        System.out.println("Inorder: ");
        inOrder(tree.root);
        // Postorder
        System.out.println();
        System.out.println("Postorder: ");
        postOrder(tree.root);
        // level order traversal
        System.out.println();
        List<List<Integer>> res = bfs(tree.root);
        System.out.println(res);
        // iterative pre Order
        System.out.println("Iterative PreOrder");
        List<Integer> pre = iterativepreOrder(tree.root);
        System.out.println(pre);
        // iterative inorder
        System.out.println("Iterative InOrder");
        List<Integer> in = iterativeInorder(tree.root);
        System.out.println(in);
        // iterative Postorder
        System.out.println("Iterative PostOrder");
        List<Integer> post = iterativePostOrder(tree.root);
        System.out.println(post);
        // iterative Postorder in One Stack
        System.out.println("Iterative PostOrder in one stack");
        List<Integer> postonest= itpostonestack(tree.root);
        System.out.println(postonest);

    }
}
