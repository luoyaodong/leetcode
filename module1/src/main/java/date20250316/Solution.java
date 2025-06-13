package date20250316;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 排列， 从n个元素里面取出m个元素； 公式是 result = n×到(n-m+1) result = m！/(n-m)!
     *
     * @param chars
     * @return
     */
    public List<List<Character>> permutation(char[] chars,int m){
        int n = chars.length;
        if(m>n){
            System.out.println("并不存在这样的排列");
            return null;
        }
        List<List<Character>> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        permutation(chars,m,list,result);
        return result;
    }

    void permutationRepeatResult(char[] chars,int m,List<Character> list,List<List<Character>> result){
        if(m == 1){
            for(int i=0;i<chars.length;i++){
                list.add(chars[i]);
                /**
                 * 使用stream进行深拷贝
                 */
                List<Character> temp = list.stream().collect(Collectors.toList());
//                System.out.println(list);
                result.add(temp);
                list.remove(list.size()-1);
            }
        }else if(m >1){
            for(int i=0;i<chars.length;i++){
                list.add(chars[i]);
                permutationRepeatResult(chars,m-1,list,result);
                list.remove(list.size()-1);
            }
        }else {
            return;
        }
    };
    void permutation(char[] chars,int m,List<Character> list,List<List<Character>> result){
        if(m == 1){
            for(int i=0;i<chars.length;i++){
                list.add(chars[i]);
                /**
                 * 使用stream进行深拷贝
                 */
                List<Character> temp = list.stream().collect(Collectors.toList());
//                System.out.println(list);
                result.add(temp);
                list.remove(list.size()-1);
            }
        }else if(m >1){
            for(int i=0;i<chars.length;i++){
                list.add(chars[i]);
                permutation(removeChars(chars,i),m-1,list,result);
                list.remove(list.size()-1);
            }
        }else {
            return;
        }
    };
    public List<List<Character>> combination(char[] chars,int m){
        int n = chars.length;
        if(m>n){
            System.out.println("并不存在这样的组合");
            return null;
        }
        List<List<Character>> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        combinationResult(0,m,chars,list,result);
        return result;
    }
    void combinationResult(int index,int k,char[] chars,List<Character> list,List<List<Character>> result){
        if(k==1){
            for(int i=index;i<chars.length;i++){
                list.add(chars[i]);
                List<Character> tempList = new ArrayList<>();
                tempList = list.stream().collect(Collectors.toList());
                result.add(tempList);
                list.remove(list.size()-1);
            }
        }else if(k>1){
            for(int i=index;i<chars.length-k+1;i++){
                list.add(chars[i]);
                combinationResult(i+1,k-1,chars,list,result);
                list.remove(list.size()-1);
            }
        }else {
            return;
        }
    }

    char[] removeChars(char[] chars,int m){
        char[] newChars =new char[chars.length-1];
        for(int i=0;i<chars.length;i++){
            if(i == m){
                continue;
            }else if(i<m) {
                newChars[i] = chars[i];
            }else if(i>m){
                newChars[i-1] = chars[i];
            }
        }
        return newChars;
    }
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        Solution solution = new Solution();
        System.out.println("排列是");
        List<List<Character>> strings = solution.permutation(chars,3);
        strings.stream().forEach(s -> {
            System.out.println(s.toString());
        });
        System.out.println("组合是");
        List<List<Character>> combineStrings = solution.combination(chars,3);
        combineStrings.stream().forEach(s->{
            System.out.println(s.toString());
        });
    }
}
