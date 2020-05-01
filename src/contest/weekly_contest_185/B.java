package contest.weekly_contest_185;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/19
 */
public class B {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String,Integer>> map = new HashMap<>();
        Set<String> food = new HashSet<>();
        Set<Integer> table = new HashSet<>();
        for(List<String> order : orders) {
            String tb = order.get(1);
            String fd = order.get(2);
            food.add(fd);
            table.add(Integer.parseInt(tb));
            if(!map.containsKey(tb)) {
                map.put(tb,new HashMap<>());
            }
            map.get(tb).compute(fd,(k,v)->{
                if(v==null) {
                    return 1;
                }
                else {
                    return v+1;
                }
            });
        }
        List<Integer> orderTable = table.stream().sorted().collect(Collectors.toList());
        List<List<String>> result = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        List<String> orderFood = food.stream().sorted().collect(Collectors.toList());
        head.addAll(orderFood);
        result.add(head);
        for(Integer tb : orderTable) {
            List<String> tmp = new ArrayList<>();
            tmp.add(tb.toString());
            for(int i=0;i<orderFood.size();i++) {
                tmp.add(map.get(tb.toString()).getOrDefault(orderFood.get(i),0).toString());
            }
            result.add(tmp);
        }
        return result;

    }

    public static void main(String[] args) {
    }
}
