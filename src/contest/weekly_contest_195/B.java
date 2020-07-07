package contest.weekly_contest_195;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/1
 */
public class B {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i]%k+k)%k]++;
        }
        for (int i = 0; i < count.length/2+1 ; i++) {
            if (count[i] != count[(k - i)%k]) {
                return false;
            }
        }
        if (count[0] % 2 != 0 || (k % 2 == 0 && count[k / 2] % 2 != 0)) {
            return false;
        }
        return true;
    }

}
