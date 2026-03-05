public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printSpiralMatrix(matrix);
    }

    private static void printSpiralMatrix(int[][] matrix) {
        int rowBeg=0;
        int rowEnd=matrix.length-1;
        int colBeg=0;
        int colEnd=matrix[0].length-1;

        while(rowBeg<=rowEnd && colBeg<=colEnd){
            for(int i= colBeg ;i<=colEnd;i++){
                System.out.printf("%d ",matrix[rowBeg][i]);
            }

            for(int j=rowBeg+1 ;j<=rowEnd;j++){
                System.out.printf("%d ",matrix[j][colEnd]);
            }

            for (int k= colEnd-1 ;k>=colBeg;k--){
                if(rowBeg==rowEnd)
                    break;
                System.out.printf("%d ", matrix[rowEnd][k]);
            }

            for (int l=rowEnd-1 ;l>=rowBeg+1;l--){
                if(colEnd==colBeg)
                    break;
                System.out.printf("%d ",matrix[l][colBeg]);
            }
            rowBeg++;
            colBeg++;
            rowEnd--;
            colEnd--;
        }
    }
}
