package util.algorithm.binary;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/1
 */
public interface QuickPower {

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


//region 私有属性
//endregion

//region 构造方法
//endregion

//region 私有方法
//endregion

//region 公共方法
//endregion

}
