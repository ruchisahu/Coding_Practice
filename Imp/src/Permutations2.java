import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public static List<List<Integer>> permute2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        boolean[] used = new boolean[nums.length];

        helper(nums,res,new ArrayList<>(),used);
        return res;
    }

    public static void helper(int[] nums,List<List<Integer>> res, List<Integer> list, boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(nums,res,list,used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String args[]){
        int[] arr = {1,1,2};
        List<List<Integer>> res = permute2(arr);
        System.out.println(res);
    }
}
