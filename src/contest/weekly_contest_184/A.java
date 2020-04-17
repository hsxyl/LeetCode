package contest.weekly_contest_184;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/12
 */
public class A {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for(int i =0 ;i<words.length;i++) {
            for(int j= 0; j<words.length;j++) {
                if(i==j) {
                    continue;
                }
                if(words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
