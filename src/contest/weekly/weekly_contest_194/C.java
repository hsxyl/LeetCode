package contest.weekly.weekly_contest_194;

import javafx.util.Pair;

import java.util.*;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/21
 */
public class C {
    public int[] avoidFlood(int[] rains) {
        final int n = rains.length;
        // 下一次下雨的时间
        int[] nextTime = new int[n];
        // 湖上一次下雨的时间
        Map<Integer,Integer> latestLakeRain = new HashMap<>();
        // key 表示要被抽干的截止时间， value表示湖编号
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        for (int i = 0; i < rains.length; i++) {
            int rain =  rains[i];
            if (latestLakeRain.containsKey(rain)) {
                nextTime[latestLakeRain.get(rain)] = i;
            }
            latestLakeRain.put(rain,i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                Pair<Integer, Integer> rainLake = pq.poll();
                if(rainLake!=null) {
                    ans[i] = rainLake.getValue();
                } else {
                    ans[i] = 1;
                }
            } else {
                if (!pq.isEmpty()&&pq.peek().getKey() <= i) {
                    return new int[0];
                }
                if(nextTime[i]!=0) {
                    pq.add(new Pair<>(nextTime[i], rains[i]));
                }
            }
        }
        return ans;
    }
}
