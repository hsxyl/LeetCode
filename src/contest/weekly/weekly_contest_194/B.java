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
public class B {

    public String[] getFolderNames(String[] names) {
        Set<String> nameSet = new HashSet<>();
        Map<String,Integer> min = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<names.length;i++) {
            String name = names[i];
            String result = name;
            if(nameSet.contains(name)) {
                do{
                    result = name+"("+min.getOrDefault(name,1)+")";
                    min.put(name,min.getOrDefault(name,1)+1);
                }while(nameSet.contains(result));
            }
            nameSet.add(result);
            ans.add(result);
        }
        String[] fuckJava = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            fuckJava[i] = ans.get(i);
        }
        return fuckJava;
    }
}
