/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int end = 0;
        int Max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(end < 0){
                end = 0;
            }
            end += nums[i];
            Max = Math.max(Max, end);
        }
        return Max;
    }
}
// @lc code=end

