public class CheckBit {
    public static void main(String[] args) {
        int num=25;
        int bit=2;
//        System.out.println(checkBit(num,bit));
        System.out.println(checkBitOpt(num,bit));
    }

    private static boolean checkBitOpt(int num, int bit) {
        return ((1 << bit) & num) != 0;
    }

    private static boolean checkBit(int num, int bit) {
        StringBuilder str = new StringBuilder();
        while(num!=0){
            str.append(num%2);
            num=num/2;
        }
//        System.out.println(str.toString());
        if (str.charAt(bit)=='1')
            return true;
        return false;
    }
}
