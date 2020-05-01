package contest.double_weekly_contest_25;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/18
 */
public class A {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = 1;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(sum<1) {
                startValue+=(1-sum);
                sum=1;
            }
        }
        return startValue;
    }
}
