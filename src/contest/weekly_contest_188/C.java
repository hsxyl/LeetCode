package contest.weekly_contest_188;

import java.util.List;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/5/10
 */
public class C {
    private static class Edge{
        public int from,to,next;
        public void update(int from,int to,int next) {
            this.from = from;
            this.to = to;
            this.next = next;
        }
        Edge(int from,int to,int next) {
            this.from =from;
            this.to = to;
            this.next=next;
        }
    }
    final int maxN = (int)(1e5*2);
    Edge[] edgeArr = new Edge[maxN];
    int[] heads = new int[maxN];
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        for(int i=0;i<n+10;i++) {
            this.heads[i] = -1;
        }

        int cnt = 0 ;
        for(int i=0;i<edges.length;i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int cur = this.heads[from];
            this.heads[from] = cnt;
            this.edgeArr[cnt] = new Edge(from,to,cur);
            cnt++;
        }
        for(int i=0;i<n+1;i++) {
            if(this.edgeArr[i]!=null) {
                System.out.println(String.format("i=%d,edge is form = %d, to =%d,next=%d",i,this.edgeArr[i].from,this.edgeArr[i].to,this.edgeArr[i].next ));
            }
        }
        return dfs(0);
    }
    int dfs(int rt) {
        int cost = 0;
        for(int i= this.heads[rt];i!=-1;i=this.edgeArr[i].next) {
            int sonCost = dfs(edgeArr[i].to);
            if(sonCost!=0) {
                sonCost++;
            }
            cost+=sonCost;
        }
        if(rt!=0&&(cost!=0||(this.hasApple.get(rt)))) {
            cost++;
        }
        return cost;
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
