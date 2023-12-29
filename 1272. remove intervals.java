import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int ArrayList = 0;

    /**
     * @param intervals: A sorted list of disjoint intervals.
     * @param toBeRemoved: An interval to be removed.
     * @return: A set of real numbers.
     */
    public int[][] deleteInterval(int[][] intervals, int[] toBeRemoved) {
        // --- write your code here ---
        List<int[]> res = new ArrayList<>();
        for(int[] cur : intervals){
            if(cur[1] < toBeRemoved[0] || cur[0] > toBeRemoved[1]){
                res.add(cur);
            }
            else{
                if(cur[0] < toBeRemoved[0]){
                    res.add(new int[]{cur[0], toBeRemoved[0]});
                }
                if(cur[1] > toBeRemoved[1]){
                    res.add(new int[]{toBeRemoved[1], cur[1]});
                }
            }
        }
        return res.toArray(new int[0][]);
    }
}