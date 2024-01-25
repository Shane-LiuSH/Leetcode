/*
 * @lc app=leetcode id=1829 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->(b[1] - a[1]));
        int res = 0;
        for(int i = 0; i < boxTypes.length; i++){
            while (boxTypes[i][0] > 0 && truckSize = 0) {
                truckSize--;
                boxTypes[i][0]--;
                res += boxTypes[i][1];
            }
        }
        return res;
    }
}
// @lc code=end

