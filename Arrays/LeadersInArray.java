import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr= {10,22,12,3,0,6};
        int[] arr2 = new int[]{4,7,1,0};
        ArrayList<Integer> res = new ArrayList<>();
        //Brute Force
        findLeader(arr2,res);//leader elem is greater than numbers to its right;
        res.clear();
        //Optimal
        findLeaderOpt(arr,res);
        System.out.println(res);

    }

    private static void findLeaderOpt(int[] arr, ArrayList<Integer> res) {
        int n= arr.length;
        res.add(arr[n-1]);
        int j=n-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[j]){
                res.add(arr[i]);
                j=i;
            }
        }
    }

    private static void findLeader(int[] arr, ArrayList<Integer> res) {
        for(int i=0;i< arr.length-1;i++){
            int j=i+1;
            for(;j< arr.length;j++){
                if(arr[j]>arr[i])
                    break;
            }
            if(j>= arr.length)
                res.add(arr[i]);
        }
        res.add(arr[arr.length-1]); //rightmost elem is always a leader


    }
}
