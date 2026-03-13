import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr={5,2,1};
        printSubSetSum(arr);
    }

    private static void printSubSetSum(int[] arr) {
        List<Integer> sumArr = new ArrayList<>();
        int subsetSum=0;
        generateSubsetSum(arr,sumArr,0,subsetSum);
        sumArr.sort((a,b)->a-b);
        System.out.println(sumArr);
    }

    private static void generateSubsetSum(int[] arr, List<Integer> sumArr, int ind, int subsetSum) {
        if(ind>=arr.length){
            sumArr.add(subsetSum);
            return;
        }
        //include
        generateSubsetSum(arr,sumArr,ind+1,subsetSum+arr[ind]);
        //not include
        generateSubsetSum(arr,sumArr,ind+1,subsetSum);

    }
}
