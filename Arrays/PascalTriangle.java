import java.util.ArrayList;
import java.util.List;

class PascalTriangle{
	
	static double funNCR(int n, int r){
		//formula nCr = n!/(r!*(n-r)!)
		
		if(n==0 || r==0)
			return 1;
		
		double res=1.0;
		for(int i=0;i<r;i++){
			res*=(n-i);
			res/=(i+1);
		}
		
		return res;
	}
	public static void main(String args[]){
		
		//given row and column, find the element in a pascal triangle
		//formula:- (r-1)C(c-1)
		int row=9,col=3;
		int element=(int)funNCR(row-1,col-1);
		System.out.println("The element is "+element);
		
		//to print nth row of a pascal triangle
		//Brute force
		for(int i=1;i<=row;i++)
			System.out.print((int)funNCR(row-1,i-1) + " ");
		System.out.println("\n\n");
		
		//optimised
		int ans=1;
		System.out.print(ans + " ");
		for(int i=1;i<row;i++){
			ans*=(row-i);
			ans/=i;
			System.out.print(ans + " ");
		}
		System.out.println("\n\n");
		
		//to print a pascal triangle of n rows
		//Brute force
		
		ArrayList<List<Integer>> final_res = new ArrayList<>();
		/*for(int i=1;i<=row;i++){
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=1;j<=i;j++){
				temp.add((int)funNCR(i-1,j-1));
			}
			final_res.add(temp);
		}
		*/
		
		//optimised
		for(int i=1;i<=row;i++){
			ArrayList<Integer> temp = new ArrayList<>();
			ans=1;
			temp.add(ans);
			for(int j=1;j<i;j++){
				ans*=(i-j);
			    ans/=j;
				temp.add(ans);
			}
			final_res.add(temp);
		}
		
		System.out.println(final_res);
	}
}

