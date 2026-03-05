import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-4,-1};
//        int[] arr = new int[]{0,1,1};
//        int[] arr = new int[]{0,0,0};


        //brute force
//        HashSet<ArrayList> res =new HashSet<>();
//
//        int n= arr.length;;
//        for (int i=0;i<n;i++){
//            for (int j=i+1;j<n;j++){
//                for(int k=j+1;k<n;k++){
//                    if(arr[i]+arr[j]+arr[k]==0){
//                        ArrayList temp= new ArrayList<>();
//                        temp.addAll(List.of(arr[i],arr[j],arr[k]));
//                        temp.sort(Comparator.naturalOrder());
//                        res.add(temp);
//                    }
//                }
//            }
//        }

        //Better
//        HashSet<ArrayList> res =new HashSet<>();
//        int n=arr.length;
//        for(int i=0;i<n;i++){
//            HashSet<Integer> set = new HashSet<>();
//            for(int j=i+1;j<n;j++){
//                int third = -arr[i]-arr[j];
//                if(set.contains(third)){
//                    ArrayList temp= new ArrayList<>();
//                    temp.addAll(List.of(arr[i],arr[j],third));
//                    temp.sort(Comparator.naturalOrder());
//                    res.add(temp);
//                }
//                set.add(arr[j]);
//            }
//        }


        //Optimal
        HashSet<ArrayList<Integer>> res =new HashSet<>();
        Arrays.sort(arr);
        int n= arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum<0)
                    j++;
                else if(sum>0)
                    k--;
                else{
                    ArrayList temp= new ArrayList<>();
                    temp.addAll(List.of(arr[i],arr[j],arr[k]));
                    res.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1])
                        j++;
                    while(j<k && arr[k]==arr[k+1])
                        k--;
                }
            }
        }
        List<List<Integer>> listOfLists = new ArrayList<>(res);
        System.out.println(res);
    }
}
