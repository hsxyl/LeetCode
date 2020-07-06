package contest.double_weekly.double_weekly_contest_27;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/30
 */
public class C {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++) map[i][i] = 1;
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        for(int k = 0 ;k<n;k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][k]==1&&map[k][j]==1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        return IntStream.range(0,queries.length).mapToObj(i->
            map[queries[i][0]][queries[i][1]]==1
        ).collect(Collectors.toList());
    }
}
