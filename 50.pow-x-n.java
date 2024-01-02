/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1){
            return x;
        }
        if( n < 0){
            return 1 / pow(x, n);
        }
        return pow(x, n);
    }
    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        double y = pow(x, n/2);
        if(n % 2 == 0){
            return y * y;
        }
        else{
            return y * y * x;
        }
    }
}
// @lc code=end

