package contest.weekly_contest_192;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/13
 */
public class A {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int index = 0;
        for(int i=0;i<n;i++) {
            ans[index] = nums[i];
            ans[index+1] = nums[i+n];
            index+=2;
        }
        return ans;
    }
}
