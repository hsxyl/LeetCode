package contest.double_weekly_contest_28;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/13
 */
public class A {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = 0; i < n ; i++) {
            int discout = 0;
            for (int j = i+1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    discout = prices[j];
                    break;
                }
            }
            ans[i] = prices[i]-discout;
        }
        return ans;
    }
}
