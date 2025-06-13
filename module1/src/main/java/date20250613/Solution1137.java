package date20250613;

/**
 * 泰波拉切数列
 */
public class Solution1137 {
    public int tribonacci(int n) {
        if(n ==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int p = 0, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; ++i) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }
}
