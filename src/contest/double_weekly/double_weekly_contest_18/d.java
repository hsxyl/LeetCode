package contest.double_weekly.double_weekly_contest_18;

public class d {

    public static int maxValueAfterReverse(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i=0;i<nums.length-1;i++) {
            sum+=Math.abs(nums[i]-nums[i+1]);
        }
        int ans = sum;
        for(int i=1;i<len-1;i++) {
            ans = Math.max(ans,sum+Math.abs(nums[0]-nums[i+1])-Math.abs(nums[i]-nums[i+1]));
            ans = Math.max(ans,sum+Math.abs(nums[i-1]-nums[len-1])-Math.abs(nums[i-1]-nums[i]));
        }
        int mx = Integer.MIN_VALUE;
        for(int i=1;i<len-1;i++) {
            ans = Math.max(ans,sum+mx-nums[i]-nums[i+1]-Math.abs(nums[i]-nums[i+1]));
            mx = Math.max(mx,nums[i]+nums[i-1]-Math.abs(nums[i-1]-nums[i]));
        }
        mx = Integer.MIN_VALUE;
        for(int i=1;i<len-1;i++) {
            ans = Math.max(ans,sum+mx+nums[i+1]-nums[i]-Math.abs(nums[i]-nums[i+1]));
            mx = Math.max(mx,nums[i-1]-nums[i]-Math.abs(nums[i-1]-nums[i]));
        }
        mx = Integer.MIN_VALUE;
        for(int i=1;i<len-1;i++) {
            ans = Math.max(ans,sum+mx+nums[i]-nums[i+1]-Math.abs(nums[i]-nums[i+1]));
            mx = Math.max(mx,nums[i]-nums[i-1]-Math.abs(nums[i-1]-nums[i]));
        }
        mx = Integer.MIN_VALUE;
        for(int i=1;i<len-1;i++) {
            ans = Math.max(ans,sum+mx+nums[i+1]+nums[i]-Math.abs(nums[i]-nums[i+1]));
            mx = Math.max(mx,-nums[i-1]-nums[i]-Math.abs(nums[i-1]-nums[i]));
        }
        return ans ;
    }
    public static void main(String[] arg) {
        int[] nums = {2,3,1,5,4};

        maxValueAfterReverse(nums);
    }
}
