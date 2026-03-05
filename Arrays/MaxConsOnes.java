class MaxConsOnes{
	public static void main(String args[]){
		int[] nums = new int[]{1,1,0,1,1,1};
		
		int temp=0, maxConsOne=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==1){
				maxConsOne++;
			}else{
				if(temp<maxConsOne){
					temp=maxConsOne;
				}
				maxConsOne=0;
			}
		}
		
		System.out.println((maxConsOne>=temp)?maxConsOne:temp);
	}
}