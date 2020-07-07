package util.datastruct.binary.树状数组;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * @author xushenbao
 * @desc 树状数组
 * @create 2020/7/7
 */
public class BinaryIndexTree {

//region 私有属性
    private int[] index;
    private int[] tree;
    private Type type;
//endregion

//region 构造方法

    public BinaryIndexTree(int[] indexs, int[] valueList, Type type) {
        if (indexs == null || indexs.length == 0) {
            throw new IllegalArgumentException(indexs == null ? "indexs为null" : "indexs大小为0");
        }
        init(indexs, valueList,type);
    }

    /**
     * @param indexList
     */
    public BinaryIndexTree(List<Integer> indexList, List<Integer> valueList, Type type) {
        if (indexList == null || indexList.size() == 0) {
            throw new IllegalArgumentException(indexList == null ? "indexList为Null" : "indexList大小为0");
        }
        init(indexList.stream().mapToInt(Integer::intValue).toArray(), valueList.stream().mapToInt(Integer::intValue).toArray(),type);
    }

    public static void main(String[] args) {
        int[] tmp = IntStream.of(2, 1, 3).toArray();
        int[] fuck = Arrays.stream(tmp).sorted().toArray();
        System.out.println(tmp);
        System.out.println(fuck);
    }
//endregion

//region 私有方法
    private void init(int[] indexs, int[] valueList,Type type) {
        this.index = Arrays.stream(indexs).sorted().toArray();
        checkIndex();
        this.type = type;
        this.tree = IntStream.range(0,this.index.length+1).map(e->this.type.initValue).toArray() ;
        for (int i = 0; i < indexs.length; i++) {
            update(indexs[i], valueList[i]);
        }
    }

    private void checkIndex() {
        for (int i = 1; i < index.length; i++) {
            if (index[i] == index[i - 1]) {
                throw new RuntimeException("索引中的数字应该是唯一的,重复数字:" + index[i]);
            }
        }
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private int mapper(int index) {
        return 0;
    }
    private int query(int index) {
        int res = type.initValue;
        for (int i = mapper(index); i < this.tree.length; i += lowBit(i)) {
            tree[i] = type.addOrUpdateOperation.apply(res,this.tree[i]);
        }
        return res;
    }

//endregion

//region 公共方法

    /**
     *
     * @param index
     * @param x
     */
    public void update(int index, int x) {
        for (int i = mapper(index); i < this.tree.length; i += lowBit(i)) {
            tree[i] = type.addOrUpdateOperation.apply(x,this.tree[i]);
        }
    }

    /**
     * 树状数组区间查询
     * @param left 左闭
     * @param right 右闭
     * @return
     */
    public int query(int left, int right) {
        return query(right) - query(left-1);
    }

//endregion

//region 公共类
public enum Type {
    SUM(0, Integer::sum,Integer::sum),
    MAX(Integer.MIN_VALUE,Integer::max,Integer::max),
    MIN(Integer.MAX_VALUE,Integer::min,Integer::min);
    int initValue;
    BiFunction<Integer,Integer,Integer> addOrUpdateOperation;
    BiFunction<Integer,Integer,Integer> queryOperation;

    Type(int initValue, BiFunction<Integer, Integer, Integer> addOrUpdateOperation, BiFunction<Integer, Integer, Integer> queryOperation) {
        this.initValue = initValue;
        this.addOrUpdateOperation = addOrUpdateOperation;
        this.queryOperation = queryOperation;
    }
}
// endregion
}
