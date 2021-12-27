import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        helper(nums,res,new ArrayList<>());
        return res;
    }

    public static void helper(int[] nums, List<List<Integer>> res,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(nums,res,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String args[]){
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
}
