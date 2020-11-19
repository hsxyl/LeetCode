package contest.weekly.weekly_contest_195;

/**
 * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 *
 * 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
 *
 * 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
 *
 *提示：
 *
 * 2 <= points.length <= 10^5
 * points[i].length == 2
 * -10^8 <= points[i][0], points[i][1] <= 10^8
 * 0 <= k <= 2 * 10^8
 * 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格递增的。
 *
 *
 * @author xushenbao
 * @desc 从前向后找，绝对值符合就可以去掉了，对于某个点(x0,y0)来说，计算公式就变为(x0+y0+y-x),所以对每个点都只需要向前找合法范围内(y-x)最大的点,直接就变成了一个区间最值问题
 * @create 2020/7/7
 */
public class D {
    public int findMaxValueOfEquation(int[][] points, int k) {
        return 0;
    }

//region 私有属性
//endregion

//region 构造方法
//endregion

//region 私有方法
//endregion

//region 公共方法
//endregion
}
