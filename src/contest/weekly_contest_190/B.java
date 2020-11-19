package contest.weekly_contest_190;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/24
 */
public class B {
    public int maxVowels(String s, int k) {
        Set<Character> yy = new HashSet();
        yy.add('a');
        yy.add('e');
        yy.add('i');
        yy.add('o');
        yy.add('u');
        int mx = 0;
        int cnt = 0;
        int l=0,r ;
        for(r = 0;r<s.length();r++) {
            if(yy.contains(s.charAt(r))) {
                cnt++;
            }
            if(r-l+1>k) {
                if(yy.contains(s.charAt(l))) {
                    cnt--;
                }
                l++;
            }
            mx = Math.max(mx,cnt);
        }
        return mx;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
