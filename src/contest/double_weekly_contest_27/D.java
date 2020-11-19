package contest.double_weekly_contest_27;

import java.util.stream.IntStream;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/30
 */
public class D {
    final int MAXN = 77;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[MAXN][MAXN][MAXN];
        boolean[][][] vis = new boolean[MAXN][MAXN][MAXN];
        dp[0][0][m-1] = grid[0][0]+grid[0][m-1];
        for (int i = 0; i < n - 1; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    if(i==0&&j1==0&&j2==m-1){
                        vis[i][j1][j2] = true;
                    }
                    if (!vis[i][j1][j2]) {
                        continue;
                    }
//                    if()
                    for (int c1 = -1; c1 <= 1; c1++) {
                        for (int c2 = -1; c2 <= 1; c2++) {
                            int jj1 = j1+c1;
                            int jj2 = j2+c2;
                            if (jj1 < 0 || jj2 < 0 || jj1 >= m || jj2 >= m) {
                                continue;
                            }
                            vis[i+1][jj1][jj2] = true;
                            dp[i+1][jj1][jj2] = Math.max(dp[i+1][jj1][jj2],dp[i][j1][j2]+grid[i+1][jj1]+(jj1==jj2?0:grid[i+1][jj2]));
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[n-1][i][j]) {
                    ans = Math.max(ans, dp[n - 1][i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean[] a = new boolean[10];
        System.out.println(a[0]);
    }
}
