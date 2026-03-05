class DiagonalStarPattern{
	private static void printDiagonalStar(int row){
		if(row<5)
			System.out.println("Invalid value");
		else{
			for(int i=0;i<row;i++){
				for(int j=0;j<row;j++){
					if(i==0||j==0||i==row-1||j==row-1)
						System.out.printf("*");
					else if(i==j || j==row-1-i)
						System.out.printf("*");
					else
						System.out.printf(" ");
					
				}
				System.out.println();
			}
				
		}
	}
	public static void main(String args[]){
		printDiagonalStar(4);
		printDiagonalStar(5);
		printDiagonalStar(8);
		printDiagonalStar(13);
		printDiagonalStar(50);
}
}