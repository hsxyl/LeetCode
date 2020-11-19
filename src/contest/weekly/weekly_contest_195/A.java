package contest.weekly.weekly_contest_195;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/1
 */
public class A {
    public boolean isPathCrossing(String path) {
        Set<String> points = new HashSet<>();
        int x =0,y=0;
        BiFunction<Integer,Integer,String> combine = (xx,yy)->xx+","+yy;
        points.add(combine.apply(x, y));
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
               x+=1;
            } else if (c == 'W') {
                y-=1;
            } else if (c == 'E') {
                y+=1;
            } else if(c=='S') {
                x-=1;
            }
            if (points.contains(combine.apply(x,y))) {
                return true;
            } else {
                points.add(combine.apply(x, y));
            }
        }
        return false;
    }
}
