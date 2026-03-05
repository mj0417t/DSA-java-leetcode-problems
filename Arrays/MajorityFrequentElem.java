import java.util.HashMap;
import java.util.Map;

public class MajorityFrequentElem {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,2,2};
        System.out.println("Most Frequent Element: "+mostFreqElem(arr));
    }

    private static int mostFreqElem(int[] arr) {
       /*
        int max=arr[0];
        for(int i=1;i< arr.length;i++)
            if(arr[i]>max)
                max=arr[i];

        int[] hash = new int[max+1];
        for(int i=0;i< arr.length;i++)
            hash[arr[i]]++;

        int mostFreqCount=Integer.MIN_VALUE;
        boolean mostFreqFound =false;
        int mostFreqElem=-1;
        for(int i=0;i< hash.length;i++){
            if(hash[i]>arr.length/2){
                if(mostFreqCount<hash[i]){
                    mostFreqCount=hash[i];
                    mostFreqElem=i;
                    mostFreqFound=true;
                }

            }
        }

        if(mostFreqFound) return mostFreqElem;
        return -1;

        */

        int n= arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry entry: map.entrySet()){
            if(Integer.parseInt(entry.getValue().toString())>n/2){
                return Integer.parseInt(entry.getKey().toString());
            }

            }
        return -1;
    }
}
