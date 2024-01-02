/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = nums1.length;
        int totalleft = nums1.length + (nums2.length - nums1.length + 1) / 2; 
        while (left <= right) {
            int x = left + (right - left) / 2;
            int y = totalleft - x;
            int xleft = (x == 0) ? Integer.MIN_VALUE : nums1[x - 1];
            int xright = (x == nums1.length) ? Integer.MAX_VALUE : nums1[x];
            int yleft = (y == 0) ? Integer.MIN_VALUE : nums2[y - 1];
            int yright = (y == nums2.length) ? Integer.MAX_VALUE : nums2[y];
            //satisfy the question
            if(xleft <= yright && yleft <= xright){
                if((nums1.length + nums2.length) % 2 == 0){
                    return (double)(Math.max(xleft, yleft) + Math.min(xright, yright)) / 2;
                }
                else{
                    return Math.max(xleft, yleft);
                }
            }
            else if(xright > yleft){
                right = x -1;
            }
            else{
                left = x + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

