import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        int num=35;
//        System.out.println(findPrimeFactors(num));
//        System.out.println(findPrimeFactorsBet(num));
        System.out.println(findPrimeFactorsOpt(num));
    }

    private static List<Integer> findPrimeFactorsOpt(int num) {
        List<Integer> primefactors = new ArrayList<>();
        if(num%2==0){
            primefactors.add(2);
            while (num%2==0)
                num/=2;
        }
        for (int i = 3; i*i <=num ; i+=2) {
            if(num%i==0){
                primefactors.add(i);
                while (num%i==0)
                    num/=i;
            }
        }
        if(num>1)
            primefactors.add(num);
        return primefactors;
    }

    private static List<Integer> findPrimeFactorsBet(int num) {
        List<Integer> res=new ArrayList<>();
        if(checkPrimeOpt(num)) res.add(num);

        for (int i = 2; i <=num/2; i++) {
            if(num%i==0 && checkPrimeOpt(i))
                res.add(i);
        }
        return res;
    }

    private static boolean checkPrimeOpt(int num) {
        int cnt=0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(num%i==0) {
                cnt++;
                if ((num / i) != i)
                    cnt++;
            }
        }
        return cnt==2;
    }

    private static List<Integer> findPrimeFactors(int num) {
        List<Integer> res=new ArrayList<>();
        if(checkPrime(num)) res.add(num);

        for (int i = 2; i <=num/2; i++) {
            if(num%i==0)
                if(checkPrime(i))
                    res.add(i);
        }
        return res;
    }

    private static boolean checkPrime(int num) {
        for (int i = 2; i <=num/2; i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }
}
