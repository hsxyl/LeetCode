package contest.double_weekly.double_weekly_contest_28;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/13
 */
public class C {
//    public class QJ{
//        QJ(int l, int r, int len) {
//            this.l = l;
//            this.r = r;
//            this.len = len;
//        }
//
//        public boolean cross(QJ qj) {
//            if (this.l>qj.r||this.r<qj.l) {
//                return false;
//            }
//            return true;
//        }
//
//        public int l,r,len;
//    }
//
//    public int minSumOfLengths(int[] arr, int target) {
//        List<QJ> list = new ArrayList<>();
//        int[] dp  = new int[arr.length+10];
//        int l=1,r =1 ;
//        int sum = 0;
//        int ans = Integer.MAX_VALUE/10;
//        BiConsumer<Integer,Integer> updateDP = (n,v) -> {
//            dp[n] = dp[n-1];
//            if (dp[n] == 0) {
//                dp[n] = v;
//            } else {
//                dp[n] = Math.min(dp[n],v);
//            }
//        };
//
//        for (; r < arr.length; r++) {
//            if (r > 0) {
//                mn[r] = mn[r-1];
//            }
//            sum+=arr[r];
//            while (sum > target) {
//                sum-=arr[l];
//                l++;
//            }
//            if (sum == target) {
//                list.add(new QJ(l, r, r - l + 1));
//                if(mn[r]==0) {
//                    mn[r] = r-l+1;
//                } else {
//                    mn[r] = Math.min(mn[r],r-l+1);
//                }
//                if (l > 0&&mn[l-1]!=0) {
//                    ans = ans == -1 ? mn[l - 1] + r - l + 1 : Math.min(ans, r - l + 1);
//                }
//            }
//        }
//        while (sum > target) {
//            sum-=arr[l];
//            l++;
//        }
//        if (sum == target) {
//            list.add(new QJ(l,r,r-l+1));
//            if(mn[r]==0) {
//                mn[r] = r-l+1;
//            } else {
//                mn[r] = Math.min(mn[r],r-l+1);
//            }
//            if (l > 0&&mn[l-1]!=0) {
//                ans = ans == -1 ? mn[l - 1] + r - l + 1 : Math.min(ans, r - l + 1);
//            }
//        }
//        if (list.size() < 2) {
//            return -1;
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[] arr =new int[3];
//        arr[0] = 1;
//        arr[1] = 6;
//        arr[1] = 1;
//        C c = new C();
//        c.minSumOfLengths(arr, 7);
//    }
}
