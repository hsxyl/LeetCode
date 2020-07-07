package util.math.模运算;

import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.function.BiFunction;

/**
 * @author xushenbao
 * @desc 求逆元
 * @create 2020/7/7
 */
public class Inverse {

//region 费马小定理求逆元
    static int inv(int num,int mod) {
        BiFunction<Integer,Integer,Integer> quickPower = (base,power) -> {
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
        };
        return quickPower.apply(num,mod-2);
    }
//endregion

//region 构造方法
//endregion

//region 私有方法
//endregion

//region 公共方法

//endregion

}
