package contest.weekly.weekly_contest_190;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/24
 */
public class D {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        dp[1][1] = nums1[0]*nums2[0];
        for(int i=1;i<=nums1.length;i++) {
            for(int j=1;j<=nums2.length;j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if(i!=1&&j!=1) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                for(int ii=i;ii>0;ii--) {
                    dp[i][j] = Math.max(dp[i][j], nums2[j-1]*nums1[ii-1]+Math.max(0,dp[ii-1][j-1]));
                }
                for(int jj=j;jj>0;jj--) {
                    dp[i][j] = Math.max(dp[i][j], nums2[jj - 1] * nums1[i - 1] + Math.max(0,dp[i - 1][jj - 1]));
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {

    }
}
