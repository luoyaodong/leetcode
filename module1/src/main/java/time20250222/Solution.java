package time20250222;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <1){
            return 0;
        }
        if(nums.length ==1){
            return 1;
        }

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
        int maxResult = 1;
        int result = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                continue;
            }else if(nums[i] +1 == nums[i+1]) {
                result++;
            }else {
                result = 1;
            }
            if(result>maxResult){
                maxResult = result;
            }
        }
        return maxResult;
    }
    public void swap(int[] nums,int j,int i){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        Solution solution = new Solution();
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }
}