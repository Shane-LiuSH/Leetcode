/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int end = prerequisites[i][0]; 
            int start = prerequisites[i][1];
            graph.computeIfAbsent(start, x->new ArrayList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for(int nei : graph.getOrDefault(cur, new ArrayList<>())){
                if(--indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return count == numCourses;
    }
}
// @lc code=end

