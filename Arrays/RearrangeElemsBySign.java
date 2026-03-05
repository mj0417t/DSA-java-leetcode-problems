import java.util.ArrayList;

public class RearrangeElemsBySign {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,-4,-5};
        rearrangeBySign(arr);
        printArray(arr);
        int[] arr2=new int[]{-1,1};
        rearrangeBySign(arr2);
        printArray(arr2);
        int[] arr3=new int[]{3,1,-2,-5,2,-4};
        rearrangeBySign(arr3);
        printArray(arr3);
    }

    private static void rearrangeBySign(int[] arr) {
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)
                negList.add(arr[i]);
            else
                posList.add(arr[i]);
        }

        int i=0,j=0,k=0;
        while(i<posList.size() && j<negList.size()){
            arr[k++]=posList.get(i++);
            arr[k++]=negList.get(j++);
        }

        while(i<posList.size()){
            arr[k++]=posList.get(i++);
        }

        while(j<negList.size()){
            arr[k++]=negList.get(j++);
        }
    }

    private static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print( arr[i]+" ");
        System.out.println();
    }
}
