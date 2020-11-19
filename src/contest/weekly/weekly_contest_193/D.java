package contest.weekly.weekly_contest_193;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/14
 */
public class D {

    public class TreeAncestor {

        int MX;
        int[][] father;

        public int log2(int n){
            return (int)(Math.log(n)/Math.log(2));
        }

        public TreeAncestor(int n, int[] parent) {
           this.MX =  log2(n)+1;
           father = new int[n+1][MX];
           for(int i=0;i<this.MX;i++) {father[0][i] = -1;}
            for (int i = 1; i <parent.length; i++) {
                for (int j = 0; j < this.MX; j++) {
                    father[i][j] = -1;
                }
                father[i][0] = parent[i];
                for (int j = 0; j < this.MX-1; j++) {
                    if(father[i][j]!=-1) {
                        father[i][j + 1] = father[father[i][j]][j];
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 0; i < this.MX+1; i++) {
                if (((1 << i) & k)!=0) {
                   node = this.father[node][i];
                }
                if(node==-1) {
                    return -1;
                }
            }
            return node;
        }

    }

    public static void main(String[] args) {

    }
}
