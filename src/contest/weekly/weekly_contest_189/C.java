package contest.weekly.weekly_contest_189;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/17
 */
public class C {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> setList = favoriteCompanies.stream().map(HashSet::new).collect(Collectors.toList());
        int len = favoriteCompanies.size();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<len;i++) {
            Set<String> st = setList.get(i);
            boolean flag = true;
            for(int j=0;j<len&&flag;j++) {
                if(j==i) {
                    continue;
                }
                if(isSubSet(st,setList.get(j))) {
                    flag = false;
                }
            }
            if(flag) {
                result.add(i);
            }
        }
        return result;
    }

    boolean isSubSet(Set<String> a,  Set<String> b) {
        Iterator<String> stringIterator = a.iterator();
        while(stringIterator.hasNext()) {
            if (!b.contains(stringIterator.next())) {
                return false;
            }
        }
        return true;
    }

}
