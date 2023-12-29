/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] cur = intervals[0];
        for(int[] interval : intervals) {
            if(cur[1] >= interval[0]) {
                // cannot ensure how many overlapping here, so don't merge now
                cur[1] = Math.max(cur[1], interval[1]);
            }
            else {
                res.add(cur);
                cur = interval;
            }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }
}
// @lc code=end

