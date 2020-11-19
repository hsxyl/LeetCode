package contest.double_weekly.double_weekly_contest_25;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/18
 */
public class C {
    int len ,k,count;
    boolean isFind;
    String ans;
    StringBuilder stringBuilder;
    private void buildHappyString(int deep) {
        if(this.isFind) {
            return;
        }
        if(deep == this.len) {
            this.count++;
            if(this.count==this.k) {
                this.isFind = true;
                ans = stringBuilder.toString();
            }
            return;
        }
        for(int i=0;i<3;i++) {
            if(deep==0||(stringBuilder.charAt(deep-1)-'a'!=i)) {
                stringBuilder.append((char)(i+'a'));
                buildHappyString(deep+1);
                stringBuilder.deleteCharAt(deep);
            }
        }
    }
    public String getHappyString(int n, int k) {
        this.len = n;
        this.k = k;
        this.count = 0;
        this.isFind = false;
        this.stringBuilder = new StringBuilder();
        this.ans="";
        buildHappyString(0);
        return this.ans;
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.getHappyString(3,9));
    }
}
