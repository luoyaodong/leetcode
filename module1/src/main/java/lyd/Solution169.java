package lyd;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer count = map.get(nums[i]);
            if(count == null){
                count = 1;
                map.put(nums[i],count);
            }else {
                count++;
                map.put(nums[i],count);
            }
            if(count>nums.length/2){
                return nums[i];
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        Solution169 solution169 = new Solution169();
        solution169.majorityElement(nums);
    }
}
