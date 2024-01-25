/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int size = 0;
        int length = j - i;
        while (i < j) {
            length = j - i;
            size =Math.max(size, length * Math.min(height[i], height[j])) ;
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return size;
    }
}
// @lc code=end

