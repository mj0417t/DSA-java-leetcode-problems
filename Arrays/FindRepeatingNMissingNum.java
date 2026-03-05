public class FindRepeatingNMissingNum {
    public static void main(String[] args) {
        int[] arr={4,3,6,2,1,1};
        //Brute Force
        int repeating =-1, missing =-1;
//        for(int i=1;i<= arr.length;i++){
//            int cnt=0;
//            for(int j=0;j< arr.length;j++){
//                if(arr[j]==i)
//                    cnt++;
//            }
//            if(cnt==2) repeating=i;
//            else if(cnt==0) missing=i;
//
//            if(repeating!=-1 && missing!=-1)
//                break;
//        }
//


        //Better using hashing

//        int[] hashArr= new int[arr.length+1];
//        for(int i=0;i< arr.length;i++)
//            hashArr[arr[i]]++;
//
//        for(int i=0;i<hashArr.length;i++){
//            if(hashArr[i]==0)
//                missing=i;
//            else if (hashArr[i]==2) {
//                repeating=i;
//            }else
//                continue;
//        }


        //Optimal using math
        //s-sn = repeating - missing
        //s2-sn2 =repeating^2 - missing^2
        int n=arr.length;
        int sumOfNnaturalNo=(n*(n+1))/2;
        int sumOfSqOfNnaturalNo=(n*(n+1)*(2*n+1))/6;
        int sumOfArray=0, squareSumofArray=0;

        for(int i=0;i<n;i++){
            sumOfArray+=arr[i];
            squareSumofArray+=(arr[i]*arr[i]);
        }
        int val1=sumOfArray-sumOfNnaturalNo;
        int val2 =squareSumofArray-sumOfSqOfNnaturalNo;
        val2=val2/val1;

        repeating=(val1+val2)/2;
        missing=val2-repeating;
        System.out.println("Repeating: "+repeating+"\nMissing: "+missing);
    }
}
