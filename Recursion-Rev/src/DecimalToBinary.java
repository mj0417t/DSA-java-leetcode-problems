public class DecimalToBinary {
    public static void main(String[] args) {
        int num=124;
        System.out.println(convertToBinary(num));
    }

    private static String convertToBinary(int num) {
        String result="";
        return findBinary(num,result);
    }

    private static String findBinary(int num, String result) {
        if(num==0) return result;
        result=num%2+result;
        return findBinary(num/2,result);
    }
}
