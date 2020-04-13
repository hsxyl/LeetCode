package weekly_contest_184;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/12
 */
public class D {
    long mod = (long)1e9+7;
    public int numOfWays(int n) {
        if(n==1) {
            return 12;
        }
        long d= 6, t= 6;
        long sum = 0 ;
        for(int i= 1;i<n;i++) {
            long nd = d*3+t*2;
            long nt = d*2+t*2;
            d = nd%mod;
            t = nt%mod;
        }
        return (int)((d+t)%mod);
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.numOfWays(5000));
    }
}
