package date20250613;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        //求的是超出最后一个台阶 这里开一个cost.len+1的dp数组
        int[] dp = new int[cost.length+1];
        //起步就是 下标 0 or 1的台阶 此处开销为0
        dp[0] = dp[1] = 0;
        for(int i = 2;i <=cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
