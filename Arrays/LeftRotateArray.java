class LeftRotateArray{
	
	static void reverse(int[] num, int a, int n){
		int temp=0, l=a, r=n;
		while(l<r){
			temp=num[l];
			num[l]=num[r];
			num[r]=temp;
			l++;
			r--;
		}
	}
	public static void main(String args[]){
		int[] num = new int[]{1,2,3,4,5,6,7};
		int k=1;
		
		//brute force
		int n = num.length;
	/*	
		if(k==0 || k==n){
			for(int i=0;i<n;i++)
			System.out.print(num[i]+" ");
		}else{
		int[] temp = new int[k];
		for(int i=0;i<k;i++)
			temp[i]=num[i];
		for(int j=k;j<n;j++)
			num[j-k]=num[j];
		int j=0;
		for(int i=n-k;i<n;i++){
			num[i]=temp[j];
			j++;
		}
		for(int i=0;i<n;i++)
			System.out.print(num[i]+" ");
		}
		*/
		//optimal solution
		
		reverse(num,0,k-1);
		reverse(num,k,n-1);
		reverse(num,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(num[i]+" ");
		
	}
}