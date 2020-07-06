package contest.weekly.weekly_contest_196;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class D {
    public String minInteger(String num, int k) {
        List<List<Integer>> numsPos = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            numsPos.add(new LinkedList<>());
        }
        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            numsPos.get(number).add(i);
        }
        int chooseCount = 0;
        boolean[] isChoose = new boolean[num.length()];
        StringBuilder sb = new StringBuilder();
        Function<Integer,Integer> findFirstMin = e-> {
          List<Integer> posList = numsPos.get(e);
          while (posList.size()!=0&& isChoose[posList.get(0)]) {
            posList.remove(0);
          }
          return posList.size()==0?-1:posList.get(0);
        };
        BiFunction<Integer,Integer,Integer> calCurCost = (source,target) -> 0;
        for (int i = 0; i < num.length(); ) {
            if (isChoose[i]) {
                continue;
            }
            int cur = num.charAt(i) - '0';
            boolean flag = false;
            for (int j = 0; j < cur; j++) {
                int mnPos = findFirstMin.apply(j);
                if (mnPos == -1||calCurCost.apply(mnPos,i)>k) {
                    continue;
                }
                isChoose[mnPos] = true;
                sb.append(j);
                chooseCount++;
                flag = true;
                break;
            }
            if (!flag) {
                isChoose[i] = true;
                sb.append(cur);
                chooseCount++;
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        boolean[] booleans = new boolean[10];
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans);
        }
    }
}
