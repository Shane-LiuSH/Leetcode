/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start){
        if(tmp.size() == k){
            res.add(new ArrayList<>(tmp));
        }
        for(int i = start; i <= n; i++){
            tmp.add(i);
            backtrack(res, tmp, n, k, i + 1);
            tmp.remove(tmp.size()-1);
        }
    }
}
// @lc code=end

