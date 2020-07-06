package contest.weekly.weekly_contest_187;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/3
 */
public class D {
    int calSumInMat(int[][] mat, List<Integer> indexList) {
        return IntStream.range(0,mat.length).map(i->mat[i][indexList.get(i)]).sum();
    }
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Pair<Integer,List<Integer>>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        Set<List<Integer>> st = new HashSet<>();
        Function<List<Integer>,Integer> calSum = e->calSumInMat(mat,e);
        List<Integer> initIndex = IntStream.range(0,mat.length).map(e->0).boxed().collect(Collectors.toList());
        pq.add(new Pair<>(calSum.apply(initIndex),initIndex));
        st.add(initIndex);
        for(int i=1;i<k;i++) {
            List<Integer> indexList = pq.poll().getValue();
            for(int j=0;j<mat.length;j++) {
                if(indexList.get(j)+1>=mat[0].length) {
                    continue;
                }
                List<Integer> newIndex = new ArrayList<>(indexList);
                newIndex.set(j,newIndex.get(j)+1);
                if(!st.contains(newIndex)) {
                    st.add(newIndex);
                    pq.add(new Pair<>(calSum.apply(newIndex),newIndex));
                }
            }
        }
        return pq.peek().getKey();
    }

}
