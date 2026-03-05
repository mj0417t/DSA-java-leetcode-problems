import java.util.PriorityQueue;

class Pair{
    double distance;
    int index;
    Pair(double distance, int index){
        this.distance=distance;
        this.index=index;
    }
}

public class MinmizeMaxDistGasStation {

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//        int k=4;
        int[] arr = {1,13,17,23};
        int k=5;

//        double dist= findMinMaxDistBtwGasStations(arr,k);
//        System.out.println("The minimum max distance between the gas stations: "+dist);

//        //Better solution using Priority Queue
//        double dist= findMinMaxDistBtwGasStationsUsingPQ(arr,k);
//        System.out.println("The minimum max distance between the gas stations: "+dist);


        //Optimal solution using Binary Search
        double dist= findMinMaxDistBtwGasStationsUsingBS(arr,k);
        System.out.println("The minimum max distance between the gas stations: "+dist);

    }

    private static double findMinMaxDistBtwGasStationsUsingBS(int[] arr, int k) {
        double maxDist =-1;
        for(int i=0;i<arr.length-1;i++){
            double dist = arr[i+1]-arr[i];
            if(dist>maxDist)
                maxDist=dist;
        }
        double low=0.0, high = maxDist;
        while (high-low >1e-6){
            double mid=(low+high)/2.0;
            int cnt = CountOfGasStations(arr,mid);
            if(cnt>k) low=mid;
            else high=mid;
        }
        return high;
    }

    private static int CountOfGasStations(int[] arr, double dist) {
        int cnt=0;
        for(int i=1;i< arr.length;i++){
            int numberInBetween =(int)((arr[i]-arr[i-1])/dist);
            if((arr[i]-arr[i-1]) ==numberInBetween*dist){
                numberInBetween--;
            }
            cnt+=numberInBetween;
        }
        return cnt;
    }

    private static double findMinMaxDistBtwGasStationsUsingPQ(int[] arr, int k) {
        int n= arr.length;
        int[] howMany = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)-> Double.compare(b.distance,a.distance)
        );

        for(int i=0;i<n-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }

        for(int i=1;i<=k;i++){
            Pair top = pq.poll();
            int idx=top.index;
            howMany[idx]++;
            double totalDist = arr[idx+1]-arr[idx];
            double newDist = totalDist/(howMany[idx]+1);
            pq.add(new Pair(newDist,idx));
        }

        return pq.peek().distance;
    }

    private static double findMinMaxDistBtwGasStations(int[] arr, int k) {
        int n=arr.length;
        int[] howMany = new int[n-1];

        for(int gasStatns=1;gasStatns<=k;gasStatns++){
            double maxSection =-1;
            int maxIndex=-1;
            for(int j=0;j<n-1;j++){
                int diff = arr[j+1]-arr[j];
                double secLength = diff/(howMany[j]+1.0);
                if(secLength>maxSection){
                    maxSection =secLength;
                    maxIndex=j;
                }
            }
            howMany[maxIndex]++;
        }

        double maxAns=-1;
        for(int i=0;i<n-1;i++){
            double secLength=(arr[i+1]-arr[i])/(howMany[i]+1.0);
            maxAns=Math.max(maxAns,secLength);
        }
        return maxAns;
    }
}
