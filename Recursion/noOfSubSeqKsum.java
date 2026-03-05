import java.util.ArrayList;

public class noOfSubSeqKsum {
    public static void main(String[] args) {
        int[] arr= new int[]{1,1,2,1,3,1,1,4,1,5,6};
        int k=3,sum=0;
        System.out.println("Total no. of subsequence with "+k+" sum: "+noOfSubSeqKsum(arr,0, new ArrayList<Integer>(),k,sum));
    }

    private static int noOfSubSeqKsum(int[] arr, int index, ArrayList<Integer> subSeq, int k, int sum) {
        if(index== arr.length){
            if(sum==k){
                System.out.println(subSeq);
                return 1;
            }else return 0;
        }
        subSeq.add(arr[index]);
        sum+=arr[index];
        int l= noOfSubSeqKsum(arr, index+1,subSeq, k, sum); //add elem at index
        subSeq.remove(subSeq.indexOf(arr[index]));
        sum-=arr[index];
        int r=noOfSubSeqKsum(arr,index+1,subSeq, k, sum);
        return l+r;
    }


}
