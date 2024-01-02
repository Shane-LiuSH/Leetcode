public class Solution {
    public int splitArray(int[] nums, int m) {
        //use binary search to get the correct max_subarrays_sum
        //compare the splitted num ?= m
        //when m == nums.legth, max is the mini(max_subarrays_sum)
        //when m = 1, sum is the mini(max_subarrays_sum)
        int max = 0;
        int sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int array_num = split(nums, mid);
            //mid is too small
            if(array_num > m){
                left = mid + 1;
            }
            // if array_num == m, modify the right to minimize the sub_sum
            else{
                right = mid - 1;
            }

        }
        //left is the minimun possile value, it represents the min(max_sub_sum) that allows splitting nums into at most m subarrays.
        return left;
    }
    public int split(int[] nums, int max_subarrays_sum){
        int subsum = 0;
        //account for the last sub_array
        int array_num = 1;
        for(int num : nums){
            if(subsum + num > max_subarrays_sum){
                subsum = 0; 
                array_num++;
            }
            subsum += num;
        }
        return array_num;
    }
}
