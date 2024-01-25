/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minimun = 0;
        int sum = 0;
        int idx = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if(sum < minimun){
                minimun = sum;
                idx = i + 1;
            }
        }
        return sum < 0 ? -1 : (idx + 1);
    }
}
// @lc code=end

