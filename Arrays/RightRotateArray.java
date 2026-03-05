class RightRotateArray{
	
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
		int k=4;
		int n=num.length;
		
		k=k%n; // when k is greaterr than size of array
		
		//brute force
	/*	int[] temp = new int[k];
		for(int i=0;i<k;i++)
			temp[i]=num[n-1-i];
		for(int i=n-1;i>=k;i--)
			num[i]=num[i-k];
		for(int i=0;i<k;i++)
			num[i]=temp[k-1-i];
		for(int i=0;i<n;i++)
			System.out.print(num[i]+" ");
		*/
		//optimal
		
		reverse(num,0,n-1);
		reverse(num,0,k-1);
		reverse(num,k,n-1);
		for(int i=0;i<n;i++)
			System.out.print(num[i]+" ");
	}
}