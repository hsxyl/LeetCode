package contest.weekly.weekly_contest_188;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/10
 */
public class B {
    public int countTriplets(int[] arr) {
        if(arr.length<2) {
            return 0;
        }
        int[][] dp = new int[arr.length+5][arr.length+5];
        int len = arr.length;
        for(int i=0;i<len;i++) {
            dp[i][i] = arr[i];
            for(int j=i+1;j<len;j++) {
                dp[i][j] = dp[i][j-1]^arr[j];
            }
        }
        int ans = 0;
        for(int j=1;j<len;j++) {
            Map<Integer, Integer> xorSum = new HashMap<>();
            for(int i=0;i<j;i++) {
                xorSum.put(dp[i][j-1],xorSum.getOrDefault(dp[i][j-1],0)+1);
            }
            for(int k=j;k<len;k++) {
                ans+=xorSum.getOrDefault(dp[j][k],0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        B b =new B();
        System.out.println(b.countTriplets(IntStream.of(1,1,1,1,1).toArray()));
    }
}
