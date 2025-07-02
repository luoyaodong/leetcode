package date20250702;

public class Solution70 {
    public int uniquePaths(int m, int n) {
        int[][] allpaths = new int[m][n];
        allpaths[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(i==0 && j ==0){
                    continue;
               }else if(i>0 && j==0){
                   allpaths[i][0] = allpaths[i-1][0];
               }else if(i==0 && j>0){
                   allpaths[0][j] = allpaths[0][j-1];
               }else if(i >0 && j>0){
                   allpaths[i][j] = allpaths[i-1][j] + allpaths[i][j-1];
               }
            }
        }
        return allpaths[m-1][n-1];
    }

    public static void main(String[] args) {
      Solution70 solution70 = new Solution70();
      int result = solution70.uniquePaths(7,3);
      System.out.println(result);
    }
}
