package contest.weekly_contest_190;

import java.util.Arrays;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/24
 */
public class A {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        for(int i=0;i<strings.length;i++) {
            if(strings[i].startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }
}
