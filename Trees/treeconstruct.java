import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class treeconstruct{
    static class Node {
        int data;
        ArrayList<Node> children=new ArrayList<>();
    }
    //faith is that first node will print its children and call its children to print their children
    static void display(Node node){
     System.out.print(node.data+" -> ");
     
     for(int i=0;i<node.children.size();i++){
         System.out.print(node.children.get(i).data+" ,");
     }
     System.out.println(".");
     for (int i = 0; i < node.children.size(); i++) {
         display(node.children.get(i));
     }
    }
    //size of tree
    static int size(Node node){
        if(node==null){
            return 0;
        }
        int ans=0;
      
       for (Node child : node.children) {
           ans+=size(child);
       }
    
       ans+=1;
      return ans;
    }
    //maximum of tree
    static int maximum(Node node){
        int maxnum=Integer.MIN_VALUE;
        for(Node child: node.children){
            int cmax=maximum(child);
            maxnum=Math.max(cmax, maxnum);
        }
        maxnum=Math.max(node.data, maxnum);
        return maxnum;
    }
    //height of tree
    static int height(Node node){
        int ht= -1;
        //intialize ht as 0 when considered height in terms of nodes 
        // intialize with -1 when calculated in terms of  edges
        for(Node child:node.children){
            int ch=height(child);
            ht=Math.max(ch, ht);
        }
        ht+=1;
        return ht;
    }
    //traversal of the tree
    static void traversal(Node node){
        System.out.println("Node pre "+node.data);
        for (Node child : node.children) {
            System.out.println("Edge pre "+node.data+" - "+child.data);
            traversal(child);
            System.out.println("Edge post "+node.data);
        }
        System.out.println("Node post "+node.data);
    }
    //level order traversal
    static void levelOrdertraversal(Node node){
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            node= q.remove();
            System.out.print(node.data+" ");
            for (Node child : node.children) {
                q.add(child);
            }
        }
    }
    //level order traversal linewise
    static void levelOrderlinewise(Node node){
        Queue<Node> pq=new ArrayDeque<>();
        pq.add(node);
        Queue<Node> cq=new ArrayDeque<>();
        while (pq.size()>0) {
            node = pq.remove();
            System.out.print(node.data+" ");
        
            for(Node child:node.children){
              cq.add(child);
            //   System.out.print(child.data);
            }
        if(pq.size()==0){
            pq=cq;
            cq=new ArrayDeque<>();
            System.out.println();
        }
    }
    }
    //level Order zig zag
    static void levelzigzag(Node node){
        Stack<Node> ps=new Stack<>();
        Stack<Node> cs=new Stack<>();
        int level=1;
        ps.push(node);
        while (ps.size()>0) {
            node = ps.pop();
            System.out.print(node.data+" ");
            if(level%2==0){
                for(int i=node.children.size()-1;i>=0;i--){
                    Node child =node.children.get(i);
                    cs.push(child);
                }
            }
            else{
                for(int i=0;i<node.children.size();i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(ps.size()==0){
                ps=cs;
                cs=new Stack<>();
                level++;
                System.out.println();
            }
        }

    }
    //remove the leaves
    static void removeleaves(Node node){
        // if we iterate the loop forward then we will miss out testiong few nodes
        // iterate in pre order 
        for(int i=node.children.size()-1;i>=0;i--){
            Node child = node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(child);
            }
        }
        for(Node child:node.children){
            removeleaves(child);
        }
    }
    public static void main(String[] args) {
        Node root=null;
        int []arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Stack<Node> treestack=new Stack<>();
        for(int i=0;i<arr.length;i++){
         Node temp=new Node();
         temp.data=arr[i];
        if(arr[i]==-1){
         treestack.pop();
        }else{
            if (treestack.isEmpty()) {
                root=temp;
                treestack.push(temp);
            } 
            else {
                treestack.peek().children.add(temp);
                treestack.push(temp);
            }
        }
        }
        display(root);
        //size
        int len=size(root);
        System.out.println(len);
        //maximum
        int max=maximum(root);
        System.err.println(max);
        //height
        int h=height(root);
        System.out.println(h);
        //traverssal
        traversal(root);
        //level order traversal
        System.out.println("Level order");
        levelOrdertraversal(root);
        //linewise
        System.out.println("");
        System.out.println("Linewise level order traversal");
        levelOrderlinewise(root);
        //zigzag level order
        System.out.println("Linewise level order traversal zig zag");
        levelzigzag(root);

        //removes leaves
        System.out.println("Removes leaves");
        removeleaves(root);
        display(root);
    }
}