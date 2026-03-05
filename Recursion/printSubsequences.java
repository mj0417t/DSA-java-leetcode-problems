import java.util.ArrayList;

public class printSubsequences {
    public static void main(String[] args) {
        int[] arr= new int[]{3,2,1};
        printSubSeq(arr,0, new ArrayList<Integer>());
    }

    private static void printSubSeq(int[] arr, int index, ArrayList<Integer> subSeq) {
        if(index== arr.length){
            System.out.println(subSeq);
            return;
        }
        subSeq.add(arr[index]);
        printSubSeq(arr, index+1,subSeq); //add elem at index
        subSeq.remove(subSeq.indexOf(arr[index]));
        printSubSeq(arr,index+1,subSeq);
    }


}
