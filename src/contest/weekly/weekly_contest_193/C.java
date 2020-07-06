package contest.weekly.weekly_contest_193;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/14
 */
public class C {
    public static boolean judge(int[] bloomDay, int d, int m ,int k ) {
        int l =0 ,r =0;
        for (; r < bloomDay.length; r++) {
            if (bloomDay[r] > d) {
                l = r+1;
            }  else if(r-l+1==k) {
                m--;
                if (m == 0) {
                    return true;
                }
                l = r+1;
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        final int MX = (int)1e9+7;
        int l = 1 ,r = MX;
        while (l < r) {
           int mid = (l+r)>>1;
            if (judge(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        if (l == MX) {
            l = -1;
        }
        return l;
    }


}
