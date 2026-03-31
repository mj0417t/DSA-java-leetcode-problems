public class SetRightMostBit {
    public static void main(String[] args) {
        int n=17;
//        System.out.println(setRightMostBit(n));
        System.out.println(setRightMostBitOpt(n));
    }

    private static int setRightMostBitOpt(int n) {
        return n|(n+1);
    }

    private static int setRightMostBit(int n) {
        int temp=n;
        StringBuilder str=new StringBuilder();
        while (temp!=0){
            str.append(temp%2);
            temp/=2;
        }

        System.out.println(str.toString());
        int num=0;
        boolean flag=true;
        for (int i =0; i <str.length();i++) {
            if(str.charAt(i)=='1')
                num+= (int) Math.pow(2,i);
            if(flag && str.charAt(i)=='0'){
                num+= (int) Math.pow(2,i);
                flag=false;
            }
        }
        return num;
    }
}
