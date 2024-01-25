/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int Far = 0;
        int length = nums.length;
        for (int i  = 0; i < length; i++) {
            if (i <= Far) {
                Far = Math.max(Far, i + nums[i]);
                if (Far >= length) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
