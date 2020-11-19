package contest.double_weekly_contest_27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/30
 */
public class A {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        target = Arrays.stream(target).sorted().toArray();
        arr = Arrays.stream(arr).sorted().toArray();
        for (int i = 0; i < target.length; i++) {
            if(target[i]!=arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
