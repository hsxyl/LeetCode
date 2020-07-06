package contest.double_weekly.double_weekly_contest_18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a {
    public int[] arrayRankTransform(int[] arr) {
        int[] tmp = arr.clone();
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        Map<Integer,Integer>  index = new HashMap<>();
        int cnt = 1;
        for(int i=0;i<sorted.length;i++) {
            if(i>0&&sorted[i]==sorted[i-1]) {
                continue;
            }
            index.put(sorted[i],cnt++);
        }
        return Arrays.stream(tmp).map(e->index.get(e)).toArray();
    }

}
