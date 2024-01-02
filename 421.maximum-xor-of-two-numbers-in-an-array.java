/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 */

// @lc code=start
class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int res = Integer.MIN_VALUE;
        for(int num : nums){
            root.addNum(root, num);
        }
        for(int num : nums){
            res = Math.max(res, root.findMax(root, num));
        }
        return res;
    }
}
class TrieNode{
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[2];
    }

    public void addNum(TrieNode root, int num){
        TrieNode node = root;
        for(int i = 31; i >= 0; i--){
            int curBit = (num >> i) & 1;
            if(node.children[curBit] == null){
                node.children[curBit] = new TrieNode();
            }
            node = node.children[curBit];
        }
    }

    public int findMax(TrieNode root, int num){
        TrieNode node = root;
        int sum = 0;
        for(int i = 31; i >= 0; i--){
            int curBit = (num >> i) & 1;
            int oppBit = curBit ^ 1;
            if(node.children[oppBit] == null){
                node = node.children[curBit];
            }
            else{
                sum += (1 << i);
                node = node.children[oppBit];
            }
        }
        return sum;
    }
}
// @lc code=end

