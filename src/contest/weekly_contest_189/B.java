package contest.weekly_contest_189;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/17
 */
public class B {
    public String arrangeWords(String text) {
        StringBuilder sb = new StringBuilder(Arrays.stream(text.split(" ")).map(String::toLowerCase).sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" ")));
        sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}
