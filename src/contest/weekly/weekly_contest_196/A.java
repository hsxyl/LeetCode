package contest.weekly.weekly_contest_196;

import java.util.Arrays;

public class A {
    public boolean canMakeArithmeticProgression(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
        int tmp = arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != tmp) {
                return false;
            }
        }
        return true;
    }
}
