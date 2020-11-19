package contest.weekly.weekly_contest_189;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/17
 */
public class D {
    double prec = 1e-8;

    public int numPoints(int[][] points, int r) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int ans = count(points, points[0][0], points[0][1], r);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                double mx = (points[i][0] + points[j][0]) / 2.0;
                double my = (points[i][1] + points[j][1]) / 2.0;
                double dirX = points[i][0] - points[j][0];
                double dirY = points[i][1] - points[j][1];
                double sqr = Math.sqrt(dirX * dirX + dirY * dirY);
                dirX /= sqr;
                dirY /= sqr;
                double h = Math.sqrt(r * r - sqr / 2 * sqr / 2);
                double moveX = -dirY;
                double moveY = dirX;

                double centerX = mx + moveX * h;
                double centerY = my + moveY * h;
                int cnt = count(points, centerX, centerY, r);
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }

    public int count(int[][] points, double x, double y, int r) {
        int ans = 0;
        for (int[] pt : points) {
            double dx = x - pt[0];
            double dy = y - pt[1];
            if (dx * dx + dy * dy <= r * r + prec) {
                ans++;
            }
        }
        return ans;
    }
    public static void main() {
        System.out.println();
    }

}
