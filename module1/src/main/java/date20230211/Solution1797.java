package date20230211;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution1797 {
    public Map<String,Integer> map = new HashMap<>();
    public int timeToLive;

    public Solution1797(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.get(tokenId) != null){
            Integer startTime = map.get(tokenId);
            int gap = currentTime - startTime;
            if(gap > timeToLive){
                //啥都不干
            }else {
                //更新
                map.put(tokenId,currentTime);
            }
        }else {

        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
       AtomicInteger count = new AtomicInteger();
       map.forEach((k,v)->{
           Integer gap = currentTime -v;
           if(gap <= timeToLive){
                count.set(count.get() + 1);
           }
       });
       return count.get();
    }

    public static void main(String[] args) {
        Solution1797 obj = new Solution1797(5);

//        obj.generate(tokenId,currentTime);
//        obj.renew(tokenId,currentTime);
//        int param_3 = obj.countUnexpiredTokens(currentTime);
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */