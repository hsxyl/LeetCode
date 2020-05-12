package contest.weekly_contest_187;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/3
 */
public class A {
    public String destCity(List<List<String>> paths) {
        Set<String> name = new HashSet<>();
        Set<String> from = new HashSet<>();
        for (List<String> path : paths) {
            from.add(path.get(0));
            if(!from.contains(path.get(1))) {
                name.add(path.get(1));
            }
            name.remove(path.get(0));
        }
        return name.iterator().next();
    }
}
