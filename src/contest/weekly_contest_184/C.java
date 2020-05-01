package contest.weekly_contest_184;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>题目链接: https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/</p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/4/12
 */
public class C {
    public String entityParser(String text) {
        Map<String,String> map = new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");

        StringBuilder sb =new StringBuilder();
        for(int i =0  ;i<text.length();i++) {
            if(i+3<text.length()&&map.containsKey(text.substring(i,i+4))) {
                sb.append(map.get(text.substring(i,i+4)));
                i = i+3;
            }
            else if(i+4<text.length()&&map.containsKey(text.substring(i,i+5))) {
                sb.append(map.get(text.substring(i,i+5)));
                i = i+4;
            }
            else if(i+5<text.length()&&map.containsKey(text.substring(i,i+6))) {
                sb.append(map.get(text.substring(i,i+6)));
                i = i+5;
            }
            else if(i+6<text.length()&&map.containsKey(text.substring(i,i+7))) {
                sb.append(map.get(text.substring(i,i+7)));
                i = i+6;
            }
            else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.entityParser("and I quote: &quot;...&quot;"));
    }
}

