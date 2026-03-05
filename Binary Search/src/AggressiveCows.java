import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
//        int[] slots = {0, 3, 4, 7, 10, 9};
//        int cows=4;
        int[] slots = {4,2,1,3,6};
        int cows=2;
//        int dist = findMaxPossMinDistance(slots,cows);
        int dist = findMaxPossMinDistanceBS(slots,cows);
        System.out.println("Max possible minimum distance="+dist);
    }

    private static int findMaxPossMinDistanceBS(int[] slots, int cows) {
        Arrays.sort(slots);
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<slots.length;i++){
            if(slots[i]>max)
                max=slots[i];
            if (slots[i]<min)
                min=slots[i];

        }
        int low=1, high=max-min;
        while (low<=high){
            int mid=(low+high)/2;
            if(canPlace(slots,mid,cows))
                low=mid+1;
            else
                high=mid-1;
        }
        return high;
    }

    private static int findMaxPossMinDistance(int[] slots, int cows) {
        Arrays.sort(slots);
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<slots.length;i++){
            if(slots[i]>max)
                max=slots[i];
            if (slots[i]<min)
                min=slots[i];

        }
        //since min 2 cows are to be put, there max possible dist is max-min
        for(int i=1;i<=(max-min);i++){
            if(canPlace(slots,i,cows))
                continue;
            else
                return i-1;
        }
        return max-min;
    }

    private static boolean canPlace(int[] slots, int dist, int cows) {
        int cntCows=1, lastSlot=slots[0];
        for(int i=1;i<slots.length;i++){
            if(slots[i]-lastSlot>=dist){
                cntCows++;
                lastSlot=slots[i];
            }
        }
        if (cntCows>=cows) return true;
        return false;
    }
}
