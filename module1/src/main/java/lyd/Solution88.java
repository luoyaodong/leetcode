package lyd;
import java.util.*;
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=0;
        int q=0;
        Queue<Integer> list1 = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            list1.offer(nums1[i]);
        }
        Queue<Integer> list2 = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            list2.offer(nums2[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<m+n;i++){
            if(n==0){
                result.add(list1.poll());
                continue;
            }else {
                if(!list1.isEmpty() && !list2.isEmpty()){
                    if(list1.peek()<=list2.peek()){
                        result.add(list1.poll());
                    }else {
                        result.add(list2.poll());
                    }
                }else if(!list1.isEmpty() && list2.isEmpty()){
                    result.add(list1.poll());
                }else if(list1.isEmpty() && !list2.isEmpty()){
                    result.add(list2.poll());
                }

            }
        }
        for(int i=0;i<m+n;i++){
            nums1[i] = result.get(i);
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        solution88.merge(nums1,3,nums2,3);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]);
        }

    }
}
