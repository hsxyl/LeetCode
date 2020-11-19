package contest.weekly.weekly_contest_173;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>题目链接: https://leetcode-cn.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/</p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 1333. 餐厅过滤器
 * @create 2020/2/7
 */
public class B {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return IntStream.range(0,restaurants.length)
                .filter(e->restaurants[e][2]==veganFriendly||veganFriendly==0)
                .filter(e->restaurants[e][3]<=maxPrice&&restaurants[e][4]<=maxDistance)
                .boxed()
                .sorted((e1,e2)->restaurants[e1][1]==restaurants[e2][1]?restaurants[e2][0]-restaurants[e1][0]:restaurants[e2][1]-restaurants[e1][1])
//                .sorted(Comparator.comparing(e->restaurants[(int)e][1],Comparator.reverseOrder()).thenComparing(e->(int)e,Comparator.reverseOrder()))
                .map(e->restaurants[e][0])
                .collect(Collectors.toList());
    }
}
