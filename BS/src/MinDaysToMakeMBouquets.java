public class MinDaysToMakeMBouquets {
    public static void main(String[] args) {
//        int[] bloomDay={1,10,3,10,2};
        int[] bloomDay={1,10,3,10,2};
        int m=3,k=1;
//        int[] bloomDay={7,7,7,7,12,7,7};
//        int m=2,k=3;
        int ans=findMinDay(bloomDay,m,k);
        System.out.printf("Minimum Days required to make %d bouquets with %d adjacent flowers is %d%n ",m,k,ans);
    }

    private static int findMinDay(int[] bloomDay, int m, int k) {
        if(bloomDay.length<m*k) return -1;
        int maxElem=Integer.MIN_VALUE;
        for(int i=0;i< bloomDay.length;i++){
            maxElem=Math.max(maxElem,bloomDay[i]);
        }
        int left=1;
        int right=maxElem;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(bouquetPossible(bloomDay,m,k,mid))
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }

    private static boolean bouquetPossible(int[] bloomDay, int m, int k, int day) {
        int cnt=0;
        for (int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]-day<=0){
                cnt++;
                if(cnt==k){
                    m--;
                    cnt=0;
                }
            }else
                cnt=0;
            if(m==0) break;
        }
        if(m==0) return true;
        return false;
    }
}
