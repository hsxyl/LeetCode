package contest.weekly_contest_185;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/19
 */
public class D {
    final int mod = (int)(1e9+7);
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n+1][m+1][k+2];
        for(int i=1;i<=m;i++) {
            dp[1][i][1] = 1;
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<=m;j++) {
                for(int z = 1;z<=k&&z<=j;z++) {
                    for(int x = 1; x<=m ; x++) {
                        if(x<=j) {
                            dp[i+1][j][z] += dp[i][j][z];
                            dp[i+1][j][z] %= mod;
                        } else {
                            dp[i+1][x][z+1] += dp[i][j][z];
                            dp[i+1][x][z+1] %= mod;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for(int i=k;i<=m;i++) {
            sum+=dp[n][i][k];
            sum%=mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.numOfArrays(2,3,1));
    }
}
