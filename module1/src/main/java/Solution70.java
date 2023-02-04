public class Solution70 {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        return climbStairs(n-2)+climbStairs(n-1);
    }
    public int climbStairs2(int n){
        int p=0; int q=0; int r=1;
        for(int i=1;i<=n;i++){
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(8));
        System.out.println(solution70.climbStairs2(8));
    }
}
