package contest.weekly_contest_188;

import java.lang.reflect.Array;
import java.util.stream.Stream;

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
        int[][][] dp = new int[k+1][row+1][col+1];
        dp[0][0][0] = 1;
        for(int z=0;z<k;z++) {
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    for(int ii=i+1;ii<=row;ii++)  {
                        if(query(i,j,ii-1,col-1)>0) {
                            dp[z+1][ii][j] += dp[z][i][j];
                            dp[z+1][ii][j] %= mod;
                        }
                    }
                    for(int jj=j+1;jj<=col;jj++)  {
                        if(query(i,j,row-1,jj-1)>0) {
                            dp[z+1][i][jj] += dp[z][i][j];
                            dp[z+1][i][jj] %= mod;
                        }
                    }
                }
            }
        }
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
        return sum[i][j] - sum[ii+1][jj] - sum[ii][jj+1] + sum[ii+1][jj+1];
    }

    public static void main(String[] args) {
        D d = new D();
        String[] tmp = new String[3];
        tmp[0] = "A..";tmp[1] = "AAA"; tmp[2] = "...";
        System.out.println(d.ways(tmp,3));

    }
}
