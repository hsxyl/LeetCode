package contest.weekly.weekly_contest_193;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/14
 */
public class B {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1 + map.getOrDefault(arr[i], 0));
        }
        List<Integer> list = map.values().stream().sorted().collect(Collectors.toList());
        int sum = map.keySet().size();
        for (int i = 0; i < list.size(); i++) {
            if (k < list.get(i)) {
                break;
            }
            sum--;
            k -= list.get(i);
        }
        return sum;
    }

}
