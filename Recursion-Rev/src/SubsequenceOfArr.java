import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArr {
    public static void main(String[] args) {
        int[] arr={3,2,1};
        printSubSeq(arr);
    }

    private static void printSubSeq(int[] arr) {
        List<Integer> arrlist=new ArrayList<>();
        printSeq(arr,0,arrlist);
    }

    private static void printSeq(int[] arr, int index, List<Integer> arrlist) {
        if(index>=arr.length){
            for(int a: arrlist)
                System.out.print(a+" ");
            System.out.println();
            return;
        }
        arrlist.add(arr[index]); //pick & add elem
        printSeq(arr,index+1,arrlist);//recurse
        arrlist.remove(arrlist.size()-1); //remove elem
        printSeq(arr,index+1,arrlist); //recurse
    }
}

//Decision tree:
//                        []
//                    /       \
//                  3          []
//               /   \       /    \
//            3,2     3     2      []
//           / \     / \   / \     / \
//         321 32   31  3 21  2   1  []