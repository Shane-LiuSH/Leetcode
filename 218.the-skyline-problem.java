/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] h : buildings){
            height.add(new int[]{h[0], -h[2]});
            height.add(new int[]{h[1], h[2]});
        }
        Collections.sort(height, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int preMax = 0;
        for(int[] b : height){
            if(b[1] < 0){
                pq.offer(-b[1]);
            }
            else{
                pq.remove(b[1]);
            }
            Integer curMax = pq.peek();
            if (curMax == null) {
                curMax = 0;
            }
            if(curMax != preMax){
                preMax = curMax;
                res.add(List.of(b[0], curMax));
            }
        }
        return res;
    }
}
// @lc code=end

