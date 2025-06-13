package date20250613;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length ==1 ){
            return cost[0];
        }else if(cost.length ==2){
            return cost[1];
        }
        int[] cost1 = new int[cost.length-1];
        int[] cost2 = new int[cost.length-2];
        Arrays.copyOf(cost,cost.length-1,cost1);
         = Arrays.copyOf(0,cost.length-2);
        int m = minCostClimbingStairs(int[])
    }


}
