/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        DSU dsu = new DSU(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i], i);
            if(map.containsKey(nums[i]+1)){
                dsu.union(i, map.get(nums[i]+1));
            }
            if(map.containsKey(nums[i]-1)){
                dsu.union(i, map.get(nums[i]-1));
            }
        }
        return dsu.findMax();
    }
}
class DSU{
    int[] parent;
    int[] size;
    public DSU(int num){
        parent = new int[num];
        size = new int[num];
        for(int i = 0; i < num; i++){
            parent[i] = i;
            size[i] = 1;
        } 
    }
    public int find(int num){
        if(parent[num] != num){
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }
        if(size[rootX] < size[rootY]){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        else{
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public int findMax(){
        int max = 0;
        for(int s : size){
            max =  Math.max(s, max);
        }
        return max;
    }
}
// @lc code=end

