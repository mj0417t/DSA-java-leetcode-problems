public class ShipWithinDDays {
    public static void main(String[] args) {
//        int[] weights={1,2,3,4,5,6,7,8,9,10};
//        int days=5;
//        int[] weights={3,2,2,4,1,4};
//        int days=3;
        int[] weights={1,2,3,1,1};
        int days=4;
        int ans=findMinCapacity(weights,days);
        System.out.printf("Minimum Capacity of the Ship required to ship within %d days %d%n ",days,ans);
    }

    private static int findMinCapacity(int[] weights, int days) {
        long maxCap=0l;
        int minCap=-1;
        for(int i=0;i<weights.length;i++){
            maxCap+=weights[i];
            if(weights[i]>minCap)
                minCap=weights[i];
        }

        long left=minCap;
        long right=maxCap;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(checkCapacity(weights,days,mid))
                right=mid-1;
            else
                left=mid+1;
        }
        return (int) left;

    }

    private static boolean checkCapacity(int[] weights, int days, long minCap) {
        int dayReq=1, load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>minCap){
                dayReq++;
                load=weights[i];
            }else
                load+=weights[i];
        }
        if(days>=dayReq) return true;
        return false;
    }
}
