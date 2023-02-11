package question1223;

import java.util.ArrayList;

class Solution {
    private static int[] rollMax;
    private static int total = 0;
    public int dieSimulator(int n, int[] rollMax) {
        total = 0;
        int[] a={1,2,3,4,5,6};
        this.rollMax = rollMax;
        repeatableArrangement(n,a);
        return total;
    }
    public static boolean ifin(int[] rollMax){
        for(int i=1;i<7;i++){
            int m = rollMax[i-1];
            int finalI = i;
            //连续数量
            Long count = tmpArr.stream().filter(temp -> temp.equals(finalI)).count();
            if(count>m){
                return false;
            }
        }
        return true;
    }
    private static ArrayList<Integer> tmpArr = new ArrayList<>();

    /**
     * 可重复排列
     * 类似自己和自己笛卡尔积，类似k层循环拼接的结果,元素个数[arr.len^3]
     * @param k 选取的元素个数（k层循环）
     * @param arr 数组
     */
    public static void repeatableArrangement(int k,int []arr){
        if(k==1){
            for(int i=0;i<arr.length;i++){
                tmpArr.add(arr[i]);

                if(ifin(rollMax)){
                    total++;
                }else {
                    System.out.print(tmpArr.toString() + ",");
                }
                tmpArr.remove(tmpArr.size()-1); //移除尾部元素
            }
        }else if(k >1){
            for(int i=0;i<arr.length;i++){
                tmpArr.add(arr[i]);
                repeatableArrangement(k - 1, arr); //不去重
                tmpArr.remove(tmpArr.size()-1); //移除尾部元素,不能用remove(Object),因为它会移除头部出现的元素，我们这里需要移除的是尾部元素
            }
        }else{
            return;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        repeatableArrangement(3,a);
    }
}