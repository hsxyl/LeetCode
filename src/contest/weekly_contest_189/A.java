package contest.weekly_contest_189;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/17
 */
public class A {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int res = 0;
        for(int i=0;i<len;i++) {
            if(queryTime>=startTime[i]&&queryTime<=endTime[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
