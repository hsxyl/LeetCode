package weekly_contest_173;

/**
 * <p>题目链接: https://leetcode-cn.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/</p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 1332. 删除回文子序列
 * @create 2020/2/7
 */
public class A {
    public int removePalindromeSub(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }
        for(int i=0;i<(s.length()+1)/2;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
                return 2;
            }
        }
        return 1;
    }
}
