package contest.weekly_contest_185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/19
 */
public class C {
    public int minNumberOfFrogs(String croakOfFrogs) {
        String frogSound = "croak";
        Map<Character,Character> lastMap = new HashMap<>();
        lastMap.put('k','a');
        lastMap.put('a','o');
        lastMap.put('o','r');
        lastMap.put('r','c');
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') {
                map.compute('c', (k, v) -> {
                    if (v == null) {
                        return 1;
                    } else {
                        return v + 1;
                    }
                });
                if (map.containsKey('k')) {
                    map.compute('k', (k, v) -> Math.max(0,v - 1));
                }
            } else {
                char last = lastMap.get(c);
                if(map.getOrDefault(last,0)==0) {
                    return -1;
                }
                map.compute(c, (k,v)->{
                   if(v==null) {
                       return 1;
                   } else {
                       return v+1;
                   }
                });
                map.compute(last,(k,v)-> {
                    return v-1;
                });
            }
        }
        if(map.get('c')+map.get('c')+map.get('r')+map.get('o')+map.get('a')!=0) {
            return -1;
        }
        return map.get('k');
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.minNumberOfFrogs("ccrrooakk"));
    }
}
