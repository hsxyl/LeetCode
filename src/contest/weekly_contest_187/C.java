package contest.weekly_contest_187;

import java.util.stream.IntStream;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/3
 */
public class C {
    int[][] mxst;
    int[][] mnst;

    public static void main(String[] arg) {
        C c = new C();

        System.out.println(c.longestSubarray(IntStream.of(8, 2, 4, 7).toArray(), 4));
    }

    void init(int[] nums) {
        mxst = new int[nums.length+5][20];
        mnst = new int[nums.length+5][20];
        for (int i = 0; i < nums.length; i++) {
            mnst[i][0] = mxst[i][0] = nums[i];
        }
        for (int j = 1; (1 << j) <= nums.length; j++) {
            for (int i = 0; i + (1 << j) - 1 < nums.length; i++) {
                mnst[i][j] = Math.min(mnst[i][j - 1], mnst[i + (1 << (j - 1))][j - 1]);
                mxst[i][j] = Math.max(mxst[i][j - 1], mxst[i + (1 << (j - 1))][j - 1]);
            }
        }
    }
    int queryMin(int l,int r) {
        int k = (int)(Math.log((double)(r - l + 1)) / Math.log(2.0));
        return Math.min(mnst[l][k],mnst[r - (1 << k) + 1][k]);
    }

    int queryMax(int l,int r) {
        int k = (int)(Math.log((double)(r - l + 1)) / Math.log(2.0));
        return Math.max(mxst[l][k],mxst[r - (1 << k) + 1][k]);
    }
    public int longestSubarray(int[] nums, int limit) {
        init(nums);
        int l, r;
        int ans = 0;
        for (l = r = 0; r < nums.length; r++) {
            while (queryMax(l , r ) - queryMin(l , r ) > limit) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
