package contest.double_weekly.double_weekly_contest_25;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/18
 */
public class B {
    static List<Integer> fib;
    static {
        final int max =(int)(1e9+7);
        fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        do {
            fib.add(fib.get(fib.size()-1)+fib.get(fib.size()-2));
        }while(fib.get(fib.size()-1)<max);
    }
    static <T> int lowerBS(int begin, int end, T aim, Function<Integer, T> indexToClass, Comparator<T> comparator) {
        while(begin<end) {
            int m =(begin+end) >>1;
            if(comparator.compare(aim,indexToClass.apply(m))>0) {
                begin = m+1;
            }
            else {
                end = m;
            }
        }
        return begin;
    }
    public int findMinFibonacciNumbers(int k) {
        int count = 0;
        while(k>0) {
            int index = lowerBS(0,fib.size(),k,fib::get,Integer::compareTo);
            if(fib.get(index)!=k) {
                index--;
            }
            k-=fib.get(index);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.findMinFibonacciNumbers(19));
    }
}
