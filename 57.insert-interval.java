/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] cur : intervals){
            if(newInterval == null || cur[1] < newInterval[0]){
                res.add(cur);
            }
            else if(cur[0] > newInterval[1]){
                res.addAll(List.of(newInterval, cur));
                newInterval = null;
            }
            else{
                //merge to a new interval
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        if(newInterval != null){
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }
}
// @lc code=end

