public class MinBitFlips {
    public static void main(String[] args) {
        int start=10, goal=82;
//        System.out.println(minBitFlips(start,goal));
        System.out.println(minBitFlipsBet(start,goal));
    }

    private static int minBitFlipsBet(int start, int goal) {
        int cnt=0;
        int xOR=start^goal;
        while (xOR!=0){
            if(xOR%2==1)
                cnt++;
            xOR/=2;
        }
        return cnt;
    }

    public static int minBitFlips(int start, int goal) {
        if(start<goal)
            return minBitFlips(goal,start);
        String startBin=getBinaryString(start);
        String goalBin=getBinaryString(goal);
        int m=startBin.length(), n=goalBin.length(),cnt=0;
        int i=0;
        for (int j=0;i<m && j<n;i++,j++){
            if(startBin.charAt(i)!=goalBin.charAt(j))
                cnt++;
        }
        while(i<m){
            if (startBin.charAt(i)!='0')
                cnt++;
            i++;
        }
        return cnt;
    }

    private static String getBinaryString(int num) {
        StringBuilder str=new StringBuilder();
        while(num!=0){
            str.append(num%2);
            num=num/2;
        }
        System.out.println(str.toString());
        return str.toString();
    }
}
