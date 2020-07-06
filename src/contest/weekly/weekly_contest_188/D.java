package contest.weekly.weekly_contest_188;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/10
 */
public class D {

    int[][] sum;


    public int ways(String[] pizza, int k) {
        final int mod = (int)(1e9+7);
        int row = pizza.length;
        int col = pizza[0].length();
        sum = new int[row+1][col+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(pizza[i].charAt(j)=='A') {
                    this.sum[i][j] = 1;
                }
            }
        }
        for(int i=row-1;i>=0;i--)
        {
            for(int j=col-1;j>=0;j--) {
                sum[i][j] = sum[i][j]+sum[i+1][j]+sum[i][j+1] - sum[i+1][j+1];
            }
        }
        // dp数组含义，切k次后剩余的披萨的起点为i,j的合法方案数
        int[][][] dp = new int[k+1][row+1][col+1];
        // 初始化，切割0次，是原本的匹萨，方案数恰为0
        dp[0][0][0] = 1;
        for(int z=0;z<k;z++) {
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    // 我为人人型dp，当前状态为dp[z][i][j]意味着切割z次后，剩余的匹萨的起始位置为(i,j)
                    // 在此状态基础上，进行横向切割后的状态为dp[z+1][ii][j],
                    // 如果在ii位置横向切割是合法的，于是dp[z][i][j]为dp[z+1][ii][j]贡献了方案数
                    for(int ii=i+1;ii<row;ii++)  {
                        if(query(i,j,ii-1,col-1)>0) {
                            dp[z+1][ii][j] += dp[z][i][j];
                            dp[z+1][ii][j] %= mod;
                        }
                    }
                    // 在此状态基础上，进行纵向切割后的状态为dp[z+1][i][jj],
                    // 如果在jj位置纵向切割是合法的，于是dp[z][i][j]为dp[z+1][i][jj]贡献了方案数
                    for(int jj=j+1;jj<col;jj++)  {
                        if(query(i,j,row-1,jj-1)>0) {
                            dp[z+1][i][jj] += dp[z][i][j];
                            dp[z+1][i][jj] %= mod;
                        }
                    }
                }
            }
        }
        // 前面得到了切割k-1刀后，匹萨所有剩余状态的合法方案数，现在需要找到剩余状态也是合法的累加起来
        int ans = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(query(i,j,row-1,col-1)>0) {
                    ans+=dp[k-1][i][j];
                    ans%=mod;
                }
            }
        }
        return ans;
    }
    int query(int i,int j,int ii,int jj) {
        return sum[i][j] - sum[ii+1][j] - sum[i][jj+1] + sum[ii+1][jj+1];
    }

    public static void main(String[] args) {
        D d = new D();
        String[] tmp = new String[3];
        tmp[0] = "A..";tmp[1] = "AAA"; tmp[2] = "...";
        assert d.ways(tmp,3)==3;

    }
}
