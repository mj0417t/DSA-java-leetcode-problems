import java.util.*;

public class Sum4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
//        int[] arr= new int[]{2,2,2,2};
        int target = 0;
        int n = arr.length;
        if (n < 4) {
            List<List<Integer>> final_res = new ArrayList<>();
            System.out.println(final_res);
        }

        HashSet<List<Integer>> res = new HashSet<>();
        //Brute force
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                for(int k=j+1;k<n;k++){
//                    for(int l=k+1;l<n;l++) {
//                        if (arr[i]+arr[j]+arr[k]+arr[l]==target){
//                            List<Integer> temp = new ArrayList(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
//                            temp.sort(Comparator.naturalOrder());
//                            res.add(temp);
//                        }
//                    }
//                }
//            }
//        }

        //Better using hashSet
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                HashSet<Integer> set = new HashSet<>();
//                for (int k=j+1; k<n;k++){
//                    long sum3=(long)arr[i]+(long)arr[j]+(long) arr[k];
//                    int fourth =(int) (target- sum3);
//
//                    if(set.contains(fourth)){
//                        List<Integer> temp = new ArrayList(Arrays.asList(arr[i],arr[j],arr[k],fourth));
//                        temp.sort(Comparator.naturalOrder());
//                        res.add(temp);
//                    }
//                    set.add(arr[k]);
//                }
//
//            }
//        }

        //optimal
        Arrays.sort(arr);
        for (int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && arr[j]==arr[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while (k<l){
                    long sum=arr[i];
                    sum+=arr[j];
                    sum+=arr[k];
                    sum+=arr[l];

                    if(sum ==target){
                        List<Integer> temp = new ArrayList(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        res.add(temp);
                        k++;
                        l--;
                        while (arr[k]==arr[k-1])
                            k++;
                        while (arr[l]==arr[l+1])
                            l--;
                    } else if (sum<target) {
                        k++;
                    }else
                        l--;
                }
            }
        }

        List<List<Integer>> listOfLists = new ArrayList<>(res);
        System.out.println(res);
    }

}
