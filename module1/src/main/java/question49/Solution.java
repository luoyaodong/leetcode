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
                if(flag == false){
                    List<String> addNewOne = new ArrayList<>();
                    addNewOne.add(strs[i]);
                    result.add(addNewOne);
                }
            }
        }
        return result;
    }
    Map<Integer,List<String>> allResultsMap = new HashMap<>();
    private boolean ifgroup(int j,List<String> tempResult,String str) {
        String numOne = tempResult.get(0);
        List<String> allStr = allResultsMap.get(j);
        if(allStr == null){
            List<String> allList = calCombo(numOne);
            allResultsMap.put(j,allList);
        }
        if(allStr.contains(str)){
            return true;
        }else {
            return false;

        }
    }

    private List<String> calCombo(String numOne) {
        List<String> calResult = new ArrayList<>();
        char[] chars = numOne.toCharArray();
        getCombo(calResult,chars);
        return calResult;
    }

    /**
     * 全排列
     * @param calResult
     * @param chars
     */
    private void getCombo(List<String> calResult, char[] chars) {

    }

}