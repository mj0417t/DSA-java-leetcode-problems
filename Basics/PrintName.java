import java.util.HashMap;
import java.util.Map;

class PrintName{
    public static void printName(int n){
        if(n==0) return;
        System.out.print("Mj ");
        printName(n-1);
    }

    public static void print1toN(int n){
        if(n==0) return;
        print1toN(n-1);
        System.out.print(n+" ");
    }

    public static void printNto1(int n){
        if(n==0) return;
        System.out.print(n+" ");
        printNto1(n-1);

    }
    public static int sumOfFirstN(int n){
        if(n==1) return n;
        return n+sumOfFirstN(n-1);

    }

    public static int factorial(int n){
        if(n==1) return n;
        return n*factorial(n-1);

    }

    public static void reverseArray(int[] arr,int i,int j) {
        if(i>=j) return;
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
        reverseArray(arr,i+1,j-1);
    }

    public static boolean isPalindrome(String s) {
        if(s.trim().isEmpty()) return true;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=Character.toLowerCase(s.charAt(i));
            if(ch>=97 && ch<=122){
                str.append(ch);
            }
        }

        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }

        return true;
    }

    public static void printElementCount(int[] arr){
       /* int max=arr[0];
        for(int i=1;i<arr.length;i++)
            if(max<arr[i])
                max=arr[i];
        int[] hash = new int[max+1];
        for(int i=0;i<arr.length;i++)
            hash[arr[i]]++;

        for(int i=0;i<hash.length;i++)
            if(hash[i]!=0)
                System.out.println(i+" -> "+hash[i]);

        */

        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
            System.out.println(entry.getKey() + " -> "+entry.getValue());

    }

    public static void main(String[] args) {
//        printName(5);
//        System.out.println();
//        print1toN(5);
//        System.out.println();
//        printNto1(5);
//        System.out.println();
//        System.out.println("Sum of first 5 natural numbers: "+sumOfFirstN(5));
//        System.out.println("Factorial of 5: "+factorial(10));
//
//        int[] arr = new int[]{10,20,30,40};
//        int j=arr.length;
//        reverseArray(arr,0,j-1);
//        for(int i=0;i<j;i++)
//            System.out.print(arr[i]+" ");
//        System.out.println();

        System.out.println(isPalindrome("ABCDCBA"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));

        //print count of all elements in an array

        int[] arr= new int[]{10,1,2,1,34,5,5,5,4,3,1,0,2,3,1};
        printElementCount(arr);

    }
}