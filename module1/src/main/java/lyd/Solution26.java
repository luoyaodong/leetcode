package lyd;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int temp = 0;
        int size = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                temp = nums[i];
                size++;
            }else {
                if(temp == nums[i]){
                   continue;
                }else {
                    temp = nums[i];
                    nums[size] = temp;
                    size++;
                }
            }
        }
        return size;
    }
}
