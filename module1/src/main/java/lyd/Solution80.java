package lyd;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int temp = 0;
        int size = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                temp = nums[i];
                size++;
                count++;
            }else {
                if(temp == nums[i]){
                    if(count==2){
                        continue;
                    }else {
                        temp = nums[i];
                        nums[size] = temp;
                        size++;
                        count++;
                    }
                }else {
                    count=1;
                    temp = nums[i];
                    nums[size] = temp;
                    size++;
                }
            }
        }
        return size;
    }
}
