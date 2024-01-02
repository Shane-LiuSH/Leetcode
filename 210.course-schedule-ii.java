/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> res = new ArrayList<>();
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
            res.add(cur);
            for(int nei : graph.getOrDefault(cur, new ArrayList<>())){
                if(--indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        if(count != numCourses){
            return new int[0];
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
// @lc code=end

