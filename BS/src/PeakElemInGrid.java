public class PeakElemInGrid {
    public static void main(String[] args) {
//        int[][] matrix={{10,20,15},{21,30,14},{7,16,32}};
        int[][] matrix={{1,2,3,1,8},{2,3,4,5,6}};
        int[] peak =findPeakCoOrds(matrix);
        System.out.printf("Peak Element = (%d,%d)",peak[0],peak[1]);
    }

    private static int[] findPeakCoOrds(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;

        int low=0, high=n-1;

        while (low<=high){

            int mid=(low+high)/2;
            int row=findRowOfMaxElemInCol(mat,m,n,mid);
            int left = (mid-1>=0)?mat[row][mid-1]:-1;
            int right = (mid+1<n)?mat[row][mid+1]:-1;

            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }else if (mat[row][mid]<left){
                high=mid-1;
            }else
                low=mid+1;

        }
        return new int[]{-1,-1};
    }

    private static int findRowOfMaxElemInCol(int[][] mat, int m, int n, int mid) {
        int maxR=-1, maxElem=-1;
        for(int i=0;i<m;i++){
            if(mat[i][mid]>maxElem){
                maxElem=mat[i][mid];
                maxR=i;
            }
        }
        return maxR;
    }
}
