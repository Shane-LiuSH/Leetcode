/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tmp, HashSet<Integer> used){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            used.add(nums[i]);
            backtrack(res, nums, tmp, used);
            tmp.remove(tmp.size()-1);
            used.remove(nums[i]);
        }
    }
}
// @lc code=end

