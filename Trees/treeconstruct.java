import java.util.ArrayList;
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
        //intializ ht as 0 when considered hright in terms of nodes 
        // intialize with -1 when calculated in terms of  edges
        for(Node child:node.children){
            int ch=height(child);
            ht=Math.max(ch, ht);
        }
        ht+=1;
        return ht;
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
    }
}