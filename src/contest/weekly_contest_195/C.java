package contest.weekly_contest_195;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author xushenbao
 * @desc 由于只在乎区间最值，所以子串的顺序是无关紧要的，直接升序后，依次计算贡献
 * @create 2020/7/1
 */
public class C {
    final int mod = ((int) (1e9 + 7));

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long sum = 0;
        // 双指针i指向小端，j指向大端
        for (int i = 0, j = nums.length - 1; j >= i && i < nums.length; i++) {
            // 找到最大满足nums[i]+nums[j]<=target的j
            while (j >= i && nums[i] + nums[j] > target) {
                j--;
            }
            if (j >= i) {
                // i处的数字必须，i+1到j位置上的数都可以选或不选
                sum += quickPower(2, j-i,  mod);
                sum %= mod;
            }
        }
        return (int)sum;
    }
    static int quickPower(int base, int power, int mod) {
        long res = 1;
        long b = base;
        while (power > 0) {
            if (power % 2 != 0) {
                res *= b;
                res %= mod;
            }
            b *= b;
            b %= mod;
            power >>= 1;
        }
        return (int) (res % mod);
    }
//    public interface formula {
//        /**
//         * 等比数列求和
//         *
//         * @param a0  首项
//         * @param q   比例系数
//         * @param n   项数
//         * @param mod 取模
//         * @return
//         */
//        static Integer sumOfGeometricProgression(Integer a0, Integer q, Integer n, Integer mod) {
//            return a0 * (1-quickPower(q, n, mod)) * inv(1 - q,mod);
//        }
//        static Integer inv(Integer n,Integer mod) {
//            return quickPower(n, mod - 2,mod);
//        }
//    }
}
