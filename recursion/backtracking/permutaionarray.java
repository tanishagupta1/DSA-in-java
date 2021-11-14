package backtracking;
import java.util.ArrayList;
import java.util.List;

public class permutaionarray {
    static List<List<Integer>> permutation(int [] nums,List<List<Integer>> ans,List<Integer> current,boolean[]visited) {
          if (current.size()==nums.length) {
              ans.add(new ArrayList<Integer>(current));
             return ans;
          }
          for (int i = 0; i < nums.length; i++) {
              if (visited[i]==true) {
                  continue;
              }
              visited[i]=true;
              current.add(nums[i]);
              permutation(nums, ans, current, visited);
              current.remove(current.size()-1);
              visited[i]=false;
          }
          return ans;
    }
    public static void main(String[] args) {
        int [] nums={1,2,3};
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        boolean [] visited=new boolean[nums.length];

        List<List<Integer>> res=permutation(nums, result, current, visited);
        System.out.println(res);
        System.out.println(res.size());

    }
}
