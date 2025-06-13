package date20230211;

/**
 * 每日温度
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int temp = temperatures[i];
            int index = 0;
            for(int j=i;j<temperatures.length;j++){
                if(temperatures[j]>temp){
                    index = j-i;
                    break;
                }
            }
            result[i] = index;
        }
        return result;
    }
}