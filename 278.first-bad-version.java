/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        int mid;
        while (start <= end ) {
            mid = start + (end - start) / 2;
            //put the target into mid, then consider return start or end
            if(isBadVersion(mid)){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return start;

    }
}
// @lc code=end

