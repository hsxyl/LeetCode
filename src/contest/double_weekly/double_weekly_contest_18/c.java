package contest.double_weekly.double_weekly_contest_18;

public class c {

    static int n,m;
    static int[][] mat;

    void sort(int x,int y) {
        for(int i=0;x+i<n&&y+i<m ;i++) {
           for(int j=i+1;x+j<n&&y+j<m;j++) {
               if(mat[x+j][y+j]<mat[x+i][y+i]) {
                   int tmp = mat[x+j][y+j];
                   mat[x+j][y+j] = mat[x+i][y+i];
                   mat[x+i][y+i] = tmp;
               }
           }
        }
    }

    public int[][] diagonalSort(int[][] mat) {
         n = mat.length;
         m = mat[0].length;
         this.mat = mat.clone();

         for(int i=0;i<n;i++) {
             sort(i,0);
         }
         for(int i=0;i<m;i++) {
             sort(0,i);
         }
         return mat;
    }
}
