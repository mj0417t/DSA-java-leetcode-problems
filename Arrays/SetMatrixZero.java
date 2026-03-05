public class SetMatrixZero {
    public static void main(String[] args) {
//        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix = {{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};

//       setMatrixZeroBF(matrix);//bruteforce TC=mn*(m+n)~n3

//        setMatrixZeroBetter(matrix); //better -TC->mn  SC->m+n
        setMatrixZeroOptimal(matrix); //TC->mn SC=)(1)
        printMatrix(matrix);
    }

    private static void setMatrixZeroOptimal(int[][] matrix) {

        int m= matrix.length;
        int n= matrix[0].length;
//       col = matrix[0][...]
//       row = matrix[...][0]
        int col0=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0)
                        matrix[0][j]=0;
                    else
                        col0=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }

        if(matrix[0][0]==0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if(col0==0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
    }

    private static void setMatrixZeroBetter(int[][] matrix) {

        int m= matrix.length;
        int n= matrix[0].length;
        int[] row = new int[m];
        int[] col= new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==1 || col[j]==1)
                    matrix[i][j]=0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
            }
    }

    private static void setMatrixZeroBF(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    markRow(i,matrix,n);
                    markCol(j,matrix,m);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)
                    matrix[i][j]=0;
            }
        }
    }

    private static void markRow(int i, int[][] matrix, int n) {
        for(int j=0;j<n;j++){
            if(matrix[i][j]!=0)
                matrix[i][j]=-1;
        }

    }

    private static void markCol(int j, int[][] matrix, int m) {
        for(int i=0;i<m;i++){
            if(matrix[i][j]!=0)
                matrix[i][j]=-1;
        }
    }

}
