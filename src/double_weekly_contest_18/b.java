package double_weekly_contest_18;

public class b {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1) {
            return "";
        }
        StringBuilder sb = new StringBuilder(palindrome);
        for(int i=0;i<sb.length();i++) {
            if(sb.length()%2==1&&i==sb.length()/2) {
                continue;
            }
            if(sb.charAt(i)!='a') {
                sb.setCharAt(i,'a');
                return sb.toString();
            }
        }
        sb.setCharAt(sb.length()-1,'b');
        return sb.toString();
    }
}
