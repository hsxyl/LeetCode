package contest.weekly.weekly_contest_188;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/10
 */
public class A {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index=1;
        for(int i=0;i<target.length;i++) {
            while(index<target[i]) {
                ans.add("Push");
                ans.add("Pop");
                index++;
            }
            ans.add("Push");
            index++;
        }
        return ans;
    }
}
