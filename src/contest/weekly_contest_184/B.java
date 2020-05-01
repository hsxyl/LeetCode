package contest.weekly_contest_184;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>题目链接: https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/</p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/12
 */
public class B {
    public int[] processQueries(int[] queries, int m) {
        int[] p = IntStream.range(1,m+1).toArray();
        return Arrays.stream(queries).map(i->{
            int index = indexOf(p,i);
            swap(p,index);
            return index;
        }).toArray();
    }

    private int indexOf(int[] p,int value) {
        for(int i =0 ;i<p.length;i++) {
            if(p[i]==value) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] p,int index) {
        int tmp = p[index];
        for(int i=index;i>0;i--) {
            p[i] = p[i-1];
        }
        p[0]=tmp;
    }

    public static void main(String[] args) {
        B b = new B();
        b.processQueries(Stream.of(3,1,2,1).mapToInt(e->e).toArray(),5);
    }

}
