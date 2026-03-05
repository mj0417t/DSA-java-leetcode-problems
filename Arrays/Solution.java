class Solution {
    public static int[] findDiagonalOrder(int[][] mat) {
        
        int m=mat.length;
        int n=mat[0].length;
        int noOfDiag=m+n-1;
        int[] arr= new int[m*n];
        int ind=0;
        for(int d=0; d<noOfDiag;d++){
            if(d%2==0){
                for(int i=m-1;i>=0;i--){
                    int j=d-i;
                    if(j>=0 && j<n){
                        arr[ind]=mat[i][j];
                        ind++;
                    }
                }
            }else{
                for(int i=0;i<m;i++){
                    int j=d-i;
                    if(j>=0 && j<n){
                        arr[ind]=mat[i][j];
                        ind++;
                    }
                }
            }
        }
        
        return arr;
    }
	
	public static void main(String args[]){
		int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int m=mat.length;
		int n=mat[0].length;
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				System.out.print(mat[i][j] + " " );
			System.out.println();
		}
		
		int[] arr = findDiagonalOrder(mat);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " " );
	}
}