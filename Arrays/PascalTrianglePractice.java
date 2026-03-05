import java.util.ArrayList;
import java.util.List;

public class PascalTrianglePractice {
    public static void main(String[] args) {
        int numRows=5;
//        List<List<Integer>> pascalTriangle=generate(numRows);
        List<List<Integer>> pascalTriangle=generateOpt(numRows);
        pascalTriangle.forEach(System.out::println);
    }

    private static List<List<Integer>> generateOpt(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer>row=new ArrayList<>();
            int ans=1;
            row.add(ans);
            for(int col=1;col<i;col++){
                ans*=i-col;
                ans/=col;
                row.add(ans);
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer>row=new ArrayList<>();
            for(int j=1;j<=i;j++){
                row.add(funcNCR(i-1,j-1));
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    private static Integer funcNCR(int r, int c) {
        int res=1;
        for(int i=0;i<c;i++){
            res*=(r-i);
            res/=(i+1);
        }
        return res;
    }
}
