/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        int N = beginWord.length();
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if (cur.equals(endWord)){
                    return step;
                }
                for(int j = 0; j < N; j++){
                    for(char letter = 'a'; letter <= 'z'; letter++){
                        StringBuilder next = new StringBuilder(cur);
                        next.setCharAt(j, letter);
                        String nextword = next.toString();
                        if(set.contains(nextword)){
                            set.remove(nextword);
                            q.offer(nextword);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
// @lc code=end

