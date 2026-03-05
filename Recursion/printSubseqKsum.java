import java.util.ArrayList;

public class printSubseqKsum {
    public static void main(String[] args) {
        int[] arr= new int[]{3,2,1};
        int k=3,sum=0;
        printSubSeq(arr,0, new ArrayList<Integer>(),k,sum);
    }

    private static void printSubSeq(int[] arr, int index, ArrayList<Integer> subSeq, int k, int sum) {
        if(index== arr.length){
            if(sum==k)
                System.out.println(subSeq);
            return;
        }
        subSeq.add(arr[index]);
        sum+=arr[index];
        printSubSeq(arr, index+1,subSeq, k, sum); //add elem at index
        subSeq.remove(subSeq.indexOf(arr[index]));
        sum-=arr[index];
        printSubSeq(arr,index+1,subSeq, k, sum);
    }


}
