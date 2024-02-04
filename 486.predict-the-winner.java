/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public int dfs(int[] nums, int left, int right, Integer[][] val){
        if(left > right){
            return 0;
        }
        if(val[left][right] != null){
            return val[left][right];
        }
        val[left][right] = Math.max(nums[left] - dfs(nums, left + 1, right, val), nums[right] - dfs(nums, left, right - 1, val));
        return val[left][right];

    }
    public boolean predictTheWinner(int[] nums) {
        Integer[][] val = new Integer[nums.length][nums.length];
        return dfs(nums, 0, nums.length - 1, val) >= 0;
    }
}
// @lc code=end

