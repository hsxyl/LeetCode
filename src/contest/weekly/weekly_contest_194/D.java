package contest.weekly.weekly_contest_194;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/6/21
 */
public class D {
    final int MX = 155;
    int[] fa = new int[MX];
    List<Edge> edges = new ArrayList<>();

    void initFa() {
        for (int i = 0; i < MX; i++) {
            fa[i] = i;
        }
    }

    int find(int x) {
        return fa[x] = (x == fa[x] ? x : find(fa[x]));
    }
    boolean union(int x,int y) {
        int xx = find(x);
        int yy = find(y);
        if(xx==yy) {
            return false;
        }
        fa[xx] = yy;
        return true;
    }

    int MST_IGNORE(int ignore,int n) {
        int cnt =0 ;
        int cost = 0;
        initFa();
        for (int i = 0; i < edges.size() && cnt < n - 1; i++) {
            if(i==ignore) {
                continue;
            }
            Edge edge = this.edges.get(i);
            if (union(edge.fo, edge.to)) {
                cost+=edge.co;
                cnt++;
            }
        }
        return cnt==n-1?cost:-1;
    }

    int MST_MUST(int must, int n) {
        int cnt = 1 ;
        int cost = this.edges.get(must).co;
        initFa();
        union(this.edges.get(must).fo, this.edges.get(must).to);

        for (int i = 0; i < edges.size() && cnt < n - 1; i++) {
            if(i==must) {
                continue;
            }
            Edge edge = this.edges.get(i);
            if (union(edge.fo, edge.to)) {
                cost+=edge.co;
                cnt++;
            }
        }
        return cnt==n-1?cost:-1;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        this.edges.clear();
        for (int i = 0; i < edges.length; i++) {
            this.edges.add(new Edge(edges[i][0], edges[i][1], edges[i][2],i ));
        }
        this.edges.sort(Comparator.comparing(Edge::getCo));
        int minCost = MST_IGNORE(-1,n);
        List<Integer> keyEdges = new ArrayList<>();
        List<Integer> notKeyEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int cost = MST_IGNORE(i,n);
            if (cost == minCost) {
                if(MST_MUST(i,n)==minCost) {
                    notKeyEdges.add(this.edges.get(i).index);
                }
            } else{
                keyEdges.add(this.edges.get(i).index);
            }
        }
        List<List<Integer>> result= new ArrayList<>();
        result.add(keyEdges);
        result.add(notKeyEdges);
        return result;
    }
    public static class Edge{
        int fo,to,co,index;
        int getCo() {
            return this.co;
        }

        Edge(int fo, int to, int co,int index) {
            this.fo = fo;
            this.to = to;
            this.co = co;
            this.index = index;
        }
    }
}
