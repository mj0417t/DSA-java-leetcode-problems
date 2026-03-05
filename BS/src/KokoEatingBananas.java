public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles={30,11,23,4,20};
        int h=8;
//        System.out.println("Required koko banana eating spped: "+findK(piles,h));
        System.out.println("Required koko banana eating speed: "+findKBS(piles,h));
    }

    private static int findKBS(int[] piles, int h) {
        int maxElem=Integer.MIN_VALUE;
        for(int i=0;i< piles.length;i++){
            maxElem=Math.max(maxElem,piles[i]);
        }
        int left=1;
        int right=maxElem;
        while(left<=right){
            int mid=left+(right-left)/2;
            int reqTime = findTotalHrs(piles,mid);
            if(reqTime<=h)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }

    private static int findK(int[] piles, int h) {
        int maxElem=Integer.MIN_VALUE;
        for(int i=0;i< piles.length;i++){
            maxElem=Math.max(maxElem,piles[i]);
        }

        for(int i=1; i<=maxElem;i++){
            int reqTime=findTotalHrs(piles,i);
            if(reqTime<=h)
                return i;
        }
        return -1;
    }

    private static int findTotalHrs(int[] piles, int hr) {
        int totalHr=0;
        for(int j=0;j< piles.length;j++){
            totalHr+=Math.ceil((double) piles[j]/hr);
        }
        return totalHr;
    }
}
