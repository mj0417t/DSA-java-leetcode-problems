public class RowWithMax1s {
    public static void main(String[] args) {
        int[][] matrix={{0,0,1},{1,1,1},{0,0,1},{0,0,0}};
//        int[][] matrix={{0,0},{0,0}};
        int rowWithMax1= findRowWithMaxOnes(matrix);
        if (rowWithMax1 == -1) {
            System.out.println("Matrix doesn't contain 1's");
        }else
            System.out.println("Row with maximum no of 1's: "+rowWithMax1);
    }

    private static int findRowWithMaxOnes(int[][] matrix) {
        int maxI=-1, maxC=0;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1)
                    cnt++;
            }
            if(cnt>maxC){
                maxC=cnt;
                maxI=i;
            }
        }
        if (maxC==0) return -1;
        return maxI;
    }
}
