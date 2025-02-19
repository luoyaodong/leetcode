package question49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * 字母异位词分组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(i == 0){
                List<String> tempResult = new ArrayList<>();
                tempResult.add(strs[i]);
                result.add(tempResult);
            }else {
                boolean flag = false;
                for(int j=0;j<result.size();j++){
                    List<String> tempResult = result.get(j);
                    //如果是在里面的则放入进去
                    if(ifgroup(j,tempResult,strs[i])){
                        tempResult.add(strs[i]);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    List<String> addNewOne = new ArrayList<>();
                    addNewOne.add(strs[i]);
                    result.add(addNewOne);
                }
            }
        }
        return result;
    }
    private static Map<Integer,List<String>> allResultsMap = new HashMap<>();
    private boolean ifgroup(int j,List<String> tempResult,String str) {
        List<String> allStr = allResultsMap.get(j);
        if(allStr == null){
            String numOne = tempResult.get(0);
            List<String> allList = getPermutations(numOne);
            allResultsMap.put(j,allList);
            if(allList.contains(str)||str.equals("")){
                return true;
            }else {
                return false;
            }
        }else {
            if(allStr.contains(str)||str.equals("")){
                return true;
            }else {
                return false;

            }
        }

    }

    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return permutations;
        }
        permute(str, "", permutations);
        return permutations;
    }

    private static void permute(String str, String prefix, List<String> permutations) {
        if (str.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char currentChar = str.charAt(i);
                String remainingString = str.substring(0, i) + str.substring(i + 1);
                permute(remainingString, prefix + currentChar, permutations);
            }
        }
    }

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"",""};
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }

}