package contest.weekly.weekly_contest_185;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/19
 */
public class A {
    public String reformat(String s) {
        List<Character> charList = new ArrayList<>();
        List<Character> intlIst = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char  c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                intlIst.add(c);
            } else {
                charList.add(c);
            }
        }
        if(Math.abs(charList.size()-intlIst.size())>1) {
            return "";
        }
        if(charList.size()>intlIst.size()) {
            stringBuilder.append(charList.get(charList.size()-1));
            stringBuilder.append(combine(intlIst,charList));
        } else if(charList.size()<intlIst.size()) {
            stringBuilder.append(intlIst.get(intlIst.size()-1));
            stringBuilder.append(combine(charList,intlIst));
        } else {
            stringBuilder.append(combine(charList,intlIst));
        }
        return stringBuilder.toString();
    }
    String combine(List<Character> list1,List<Character> list2) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<Math.min(list1.size(),list2.size());i++) {
            stringBuilder.append(list1.get(i));
            stringBuilder.append(list2.get(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
    }
}
