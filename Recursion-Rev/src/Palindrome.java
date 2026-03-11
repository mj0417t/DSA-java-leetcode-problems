public class Palindrome {
    public static void main(String[] args) {
        String str1= "racecar";
        String str2= "aloha";
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
    }

    private static boolean isPalindrome(String str) {
        if(str.isEmpty() ||str.length()==1)
            return true;
        if(str.charAt(0)==str.charAt(str.length()-1))
            return isPalindrome(str.substring(1,str.length()-1));
        return false;
    }
}
