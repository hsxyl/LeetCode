package contest.weekly.weekly_contest_190;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/24
 */
public class C {
    static Map<Integer,Integer> map = new HashMap<>();
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public int pseudoPalindromicPaths (TreeNode root) {
          map.clear();
          return dfs(root);
    }
    public static boolean checkIfP() {
          return map.values().stream().filter(e->e%2==1).count()<2;
    }

    public int dfs(TreeNode rt) {
        if(rt==null) {
            return 0;
        }
        map.put(rt.val,map.getOrDefault(rt.val,0)+1);
        int res;
        if (rt.left == null && rt.right == null) {
            res = checkIfP()?1:0;
        } else {
            res = dfs(rt.left)+dfs(rt.right);
        }
        map.put(rt.val,map.get(rt.val)-1);
        return res;
    }

    public static void main(String[] args) {
//        TreeNode d31 = new TreeNode(3,null,null);
//        TreeNode d32 = new TreeNode(1,null,null);
//        TreeNode d33 = new TreeNode(1,null,null);
//        TreeNode d21 = new TreeNode(3,null,null);
//        TreeNode d22 = new TreeNode(1,null,null);
//        TreeNode d11 = new TreeNode(2,null,null);

        TreeNode d21 = new TreeNode(1,null,null);
        TreeNode d22 = new TreeNode(1,null,null);
        TreeNode d11 = new TreeNode(9,d21,d22);
        C c = new C();
        System.out.println(c.pseudoPalindromicPaths(d11));
    }
}
