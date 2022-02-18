import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class binarytreeconstruct {
    //Node for Binary Tree
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
    public static class construct{
        Node root;
        construct(){
            root = null;
        }
        construct(int val){
            root = new Node(val, null, null);
        }
    }
    //Time  Complexity of preOrder is O(n) where n is the numbe of nodes Space complexity : O(n)
    static void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ->");
        preOrder(node.left);
        preOrder(node.right);
        
    }
    static void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+"-> ");
        inOrder(node.right);
    }
    static void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+"-> ");
    }
    static List<List<Integer>> bfs(Node node){
        List<List<Integer>> ans =new ArrayList<>();
        if(node==null){
          ans.add(new ArrayList<>());
          return ans;
        }
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            List<Integer> temp =new ArrayList<>();
            int len= q.size();
            for(int i=0;i<len;i++){
                Node t = q.remove();
                temp.add(t.data);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                  q.add(t.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        construct tree =new construct();
        tree.root = new Node(1, null, null);
        tree.root.left = new Node(2, null, null);
        tree.root.right = new Node(3, null, null);
        tree.root.left.left = new Node(4, null, null);
        tree.root.left.right = new Node(5, null, null);
        tree.root.left.right.left = new Node(6, null, null);
        tree.root.left.right.right = new Node(7, null, null);

        //PreOrder
        System.out.println("Preorder: ");
        preOrder(tree.root);
        //Inorder
        System.out.println();
        System.out.println("Inorder: ");
        inOrder(tree.root);
        //Postorder
        System.out.println();
        System.out.println("Postorder: ");
        postOrder(tree.root);
        //level order traversal
        System.out.println();
        List<List<Integer>>res= bfs(tree.root);
        System.out.println(res);
    }
}