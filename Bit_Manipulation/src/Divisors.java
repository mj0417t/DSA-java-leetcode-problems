import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {
    public static void main(String[] args) {
        int n=36;
        System.out.println(printAllDivisors(n));
    }

    private static List<Integer> printAllDivisors(int n) {
        List<Integer> divisors= new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                divisors.add(i);
                if(n/i!=i)
                    divisors.add(n/i);
            }
        }
        Collections.sort(divisors);
        return divisors;
    }
}
