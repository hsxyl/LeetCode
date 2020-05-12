package problem.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/21
 */
public class LeetCode330 {
    public int minPatches(int[] nums, int n) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> isGet = new HashSet<>();
        for(int i=1;i<=n;i++) {
            if(isGet.contains(i)) {
                
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
