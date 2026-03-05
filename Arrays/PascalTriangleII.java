import java.util.ArrayList;
import java.util.List;
class PascalTriangleII {
    public static int ncr(int n, int r){
//formula nCr = n!/(r!*(n-r)!)
		
		if(n==0 || r==0)
			return 1;
		
		double res=1.0;
		for(int i=0;i<r;i++){
			res*=(n-i);
			res/=(i+1);
		}
		
		return (int)res;
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        //list.add(1);
        for(int i=1;i<=rowIndex;i++)
            list.add(ncr(rowIndex-1,i-1));
		return list;
    }
	
	public static void main(String args[]){
		int row=14;
		List<Integer> list = getRow(row);
		System.out.println(list);
	}
}