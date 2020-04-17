package problem.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>题目链接: https://leetcode-cn.com/problems/remove-duplicate-letters/</p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 去除重复字母
 * @create 2020/4/16
 */
public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] isUsed = new boolean[26];
        for(int i=0;i<s.length();i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }
        Deque<Character> deque = new LinkedList<>();
        int limit = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i)-'a';
            if(isUsed[index]) {
                continue;
            }
            limit = Math.min(limit,lastIndex[index]);
            updateStack(deque,s.charAt(i));
            if(limit==i) {
                while(deque.size()!=0&&deque.peekFirst().compareTo(s.charAt(i))<=0) {
                    char c = deque.pollFirst();
                    sb.append(c);
                    isUsed[c-'a'] = true;
                }
                limit = s.length();
            }
        }
        return sb.toString();
    }

    void updateStack(Deque<Character> deque, char c) {
        if(deque.contains(c)) {
            return;
        }
        while(deque.size()!=0&&deque.peekLast()>=c) {
            deque.removeLast();
        }
        deque.add(c);
    }

    public static void main(String[] args) {
        LeetCode316  leetCode316 = new LeetCode316();
        System.out.println(leetCode316.removeDuplicateLetters("abacb"));

    }
}
