package template.datastruct.树状数组;

import java.util.List;
import java.util.function.Function;

/**
 * <p>题目链接: </p>
 *
 * @author xushenbao
 * @desc 树状数组
 * @create 2020/7/5
 */
public class BinaryIndexTree {
    /**
     * 总大小
     */
    int n;
    /**
     * 映射, 树状数组下标必须使用1-n,所以需要将有序列表的索引映射到1-n
     */
    Function<Integer,Integer> mapper;

    BinaryIndexTree(int n) {
        this.n = n;
    }
    BinaryIndexTree(List<Integer> indexList) {
        this.n = indexList.size();
        indexList.sort(Integer::compareTo);
    }
    int lowbit(int x) {
        return x&(-x);
    }



}
