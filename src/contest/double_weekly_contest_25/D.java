package contest.double_weekly_contest_25;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/18
 */
public class D {
    final int mod = (int)(1e9+7);
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        for(int i=0;i<s.length();i++) {
            long sum = 0;
            if(s.charAt(i)=='0') {
                continue;
            }
            for(int j=i;j<s.length();j++) {
                sum= sum*10+s.charAt(j)-'0';
                if(sum>k) {
                    break;
                }
                dp[j+1] += dp[i];
                dp[j+1]%=mod;
            }
        }
        return dp[s.length()];
    }

}
