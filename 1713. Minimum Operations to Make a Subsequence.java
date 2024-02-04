

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map =new HashMap<>();
        for(int i = 0 ; i < target.length; i++){
            map.put(target[i], i);
        }
        int[] nums = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++){
            nums[i] = map.getOrDefault(arr[i], -1);
        }
        return target.length - lengthOfLIS(nums);
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            if(x == -1){
                continue;
            }
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
// @lc code=end
