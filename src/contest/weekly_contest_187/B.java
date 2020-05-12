package contest.weekly_contest_187;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/3
 */
public class B {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -k-5;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                if(i-lastIndex<=k) {
                    return false;
                }
                lastIndex = i;
            }
        }
        return true;
    }
}
