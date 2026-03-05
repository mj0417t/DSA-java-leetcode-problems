import java.util.ArrayList;
import java.util.List;

public class RomanToInteger {
    public static void main(String[] args) {
        String s1="III";
        String s2="LVIII";
        String s3="MCMXCIV";
        try {
            System.out.println("Integer value of Roman s1: "+romanToInt(s1));
            System.out.println("Integer value of Roman s2: "+romanToInt(s2));
            System.out.println("Integer value of Roman s3: "+romanToIntOpt(s3));
        }catch (IllegalArgumentException e){
            System.out.println("IllegalArgument "+e);
        }

    }

    private static int romanToIntOpt(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int val = toValue(s.charAt(i));

            if(i<s.length()-1 && val< toValue(s.charAt(i+1)))
                res-=val;
            else
                res+=val;
        }
        return res;
    }

    private static int toValue(char ch) {
        switch (ch){
            case 'I'-> {
                return 1;
            }
            case 'V' -> {
                return 5;
            }
            case 'X' -> {
                return 10;
            }
            case 'L' -> {
                return 50;
            }
            case 'C' -> {
                return 100;
            }
            case 'D' -> {
                return 500;
            }
            case 'M' -> {
                return 1000;
            }
            default -> {
                return 0;
            }
        }
    }

    private static int romanToInt(String s) throws IllegalArgumentException {
        int ans=0;
        char prevChar='u';
        List<Character> symbol = new ArrayList<>(List.of('I','V','X','L','C','D','M'));
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            int  digVal=0;
            switch (ch){
                case 'I'-> digVal=1;
                case 'V' ->digVal=5;
                case 'X' ->digVal=10;
                case 'L' ->digVal=50;
                case 'C' ->digVal=100;
                case 'D' ->digVal=500;
                case 'M' ->digVal=1000;
                default -> throw new IllegalArgumentException();
            }

            if(i+1==s.length()){
                ans+=digVal;
            }else if (symbol.indexOf(ch)<symbol.indexOf(prevChar)) {
                ans -= digVal;
            } else {
                ans += digVal;
            }

            prevChar=ch;
        }

        return ans;
    }
}
