import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {2, 6}, {8, 9}, {8, 10}, {9, 11}, {15, 18}, {16, 17}};
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
//        System.out.println(Arrays.deepToString(arr));

        List<List<Integer>> res = new ArrayList<>();

//        int n= arr.length;
//        int i=0;
//        while (i<n){
//            int start =arr[i][0];
//            int end = arr[i][1];
//
//            int j=i+1;
//            while (j<n && arr[j][0]<=end){
//                end=Math.max(end,arr[j][1]);
//                j++;
//            }
//            res.add(Arrays.asList(start,end));
//            i=j;
//        }

        //Optimal
        for(int[] interval:arr){
            if(res.isEmpty()|| res.get(res.size()-1).get(1)<interval[0]){
                res.add(Arrays.asList(interval[0],interval[1]));
            }else {
                int last=res.size()-1;
                int maxEnd=Math.max(res.get(last).get(1), interval[1]);
                res.get(last).set(1,maxEnd);
            }
        }
        int[][] result=new int[res.size()][2];
        int i=0;
        for(List<Integer> ar:res){
            int[] intArray = ar.stream().mapToInt(Integer::intValue).toArray();
            result[i++]=intArray;
        }
        System.out.println(Arrays.deepToString(result));
    }
}
