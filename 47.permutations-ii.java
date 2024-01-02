/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            //for duplicate num, only add the first one to the tmp
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == true){
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            backtrack(res, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
// @lc code=end

