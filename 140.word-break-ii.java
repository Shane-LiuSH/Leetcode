/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        List<Integer>[] dp =new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(0);
        Set<String> dic = new HashSet<>(wordDict);
        for(int i = 0; i <= N; i++){
            for(int j = 0; j < i; j++){
                if(!dp[j].isEmpty() && dic.contains(s.substring(j, i))){
                    dp[i].add(j);
                }
            }
        }
        getResult(N, "", dp, s);
        return res;
    }

    public void getResult(int index, String cur, List<Integer>[] dp, String s){
        if(index == 0){
            res.add(cur.trim());
            return;
        }
        for(int preindex : dp[index]){
            getResult(preindex, s.substring(preindex, index) + " " + cur, dp, s);
        }
    }
}
// @lc code=end

