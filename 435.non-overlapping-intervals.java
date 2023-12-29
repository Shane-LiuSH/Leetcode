/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b)-> a[1] - b[1]);
        int end = Integer.MIN_VALUE;
        for(int[] cur : intervals){
            if(end <= cur[0]){
                end = cur[1];
            }
            else{
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

