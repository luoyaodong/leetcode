package date20250613;

/**
 * 斐波拉契数列
 */
public class Solution509 {
    public int fib(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
