package contest.double_weekly.double_weekly_contest_27;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/30
 */
public class B {
    public boolean hasAllCodes(String s, int k) {
        int tmp = 0;
        for(int i=0;i<k;i++) {
            tmp<<=1;
            tmp|=1;
        }
        Set<Integer> st = new HashSet<>();
        int c = 0;
        for (int i = s.length()-1; i >=Math.max(0, s.length()- k); i--) {
            c<<=1;
            if (s.charAt(i) == '1') {
                c|=1;
            }
        }
        st.add(c);
        for (int i = s.length()-k; i >= 0; i--) {
            c <<=1;
            if (s.charAt(i) == '1') {
                c|=1;
            }
            st.add(c & tmp);
        }
        return st.size()==(1<<k);
    }

}
