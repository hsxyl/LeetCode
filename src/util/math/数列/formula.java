package util.math.数列;

/**
 * @author xushenbao
 * @desc 公式
 * @create 2020/7/1
 */
public class formula {
    static int quickPower(int base, int power, int mod) { long res = 1; while (power > 0) { if (power % 2 != 0) { res*=base; res%=mod; } base*=base; base%=mod; power>>=1; } return (int)(res%mod); }
    /**
     * 等比数列求和
     * @param a0 首项
     * @param q 比例系数
     * @param n 项数
     * @return
     */
    Integer sumOfGeometricProgression(Integer a0,Integer q,Integer n,Integer mod) {
        return a0 * quickPower(1-q,n,mod)/(1-q);
    }
}
