public class LargestOddNumStr {

    public static void main(String[] args) {
        String str="3456789";
//        System.out.println(largestOddNumber(str));
        System.out.println(largestOddNumberOpt(str));
    }

    private static String largestOddNumberOpt(String num) {

        for(int i=num.length()-1;i>=0;i--){

            if((int)num.charAt(i)%2!=0)
                return num.substring(0,i+1);
        }
        return "";
    }

    private static String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){

            if(Integer.parseInt(String.valueOf(num.charAt(i)))%2!=0)
                return num.substring(0,i+1);
        }
        return "";
    }
}
