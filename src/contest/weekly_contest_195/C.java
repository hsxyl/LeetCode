package contest.weekly_contest_195;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/1
 */
public class C {
    final int mod = ((int) (1e9 + 7));

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.numSubseq(Stream.of(1, 2, 3).mapToInt(Integer::intValue).toArray(), 9));
    }

    public int numSubseq(int[] nums, int target) {
        nums = Arrays.stream(nums).sorted().toArray();
        int sum = 0;
        for (int i = 0, j = nums.length - 1; j >= i && i < nums.length; i++) {
            while (j >= i && nums[i] + nums[j] > target) {
                j--;
            }
            if (j >= i) {
                sum += formula.quickPower(2, j - i, mod);
                sum %= mod;
            }
        }
        return sum;
    }

    public interface formula {
        static int quickPower(int base, int power, int mod) {
            long res = 1;
            while (power > 0) {
                if (power % 2 != 0) {
                    res *= base;
                    res %= mod;
                }
                base *= base;
                base %= mod;
                power >>= 1;
            }
            return (int) (res % mod);
        }

        /**
         * 等比数列求和
         *
         * @param a0  首项
         * @param q   比例系数
         * @param n   项数
         * @param mod 取模
         * @return
         */
        static Integer sumOfGeometricProgression(Integer a0, Integer q, Integer n, Integer mod) {
            return a0 * quickPower(1 - q, n, mod) / (1 - q);
        }
    }
}
