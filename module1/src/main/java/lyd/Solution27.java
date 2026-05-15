package lyd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list = list.stream().filter(integer -> !integer.equals(val)).collect(Collectors.toList());
        for(int i=0;i<nums.length;i++){
            if(i<list.size()){
                nums[i] = list.get(i);
            }else {
                nums[i] = -100;
            }
        }
        return list.size();
    }

}
