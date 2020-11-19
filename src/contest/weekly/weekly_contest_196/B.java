package contest.weekly.weekly_contest_196;

public class B {
    public int getLastMoment(int n, int[] left, int[] right) {
        int mx = 0 ;
        for (int i = 0; i < left.length; i++) {
            mx = Math.max(mx,left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            mx = Math.max(mx, n - right[i]);
        }
        return mx;
    }
}
