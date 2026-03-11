public class PrintStringInRevOrder {
    public static void main(String[] args) {
        String str = "aroma";
        printRev(str);

    }

    private static void printRev(String str) {
        helper(str,0);
    }

    private static void helper(String str, int index) {
        if(str==null || index>=str.length()) return;
        helper(str,index+1);
        System.out.print(str.charAt(index));
    }
}
