import java.util.ArrayList;
import java.util.List;

public class CountPrimesInRange {
    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(List.of(1,7)));
        queries.add(new ArrayList<>(List.of(3,7)));

        System.out.println(countPrimesinRange(queries));
    }

    private static List<Integer> countPrimesinRange(List<List<Integer>> queries) {

        if(queries==null|| queries.isEmpty()) return new ArrayList<>();

        // Find the maximum value in the queries
        // to determine the sieve range
        int maxVal = 0;
        for (List<Integer> query : queries) {
            maxVal = Math.max(maxVal, query.get(1));
        }

        //constructing seive
        int[] primes=new int[maxVal+1];
        for (int i = 2; i <=maxVal; i++)
            primes[i]=1;
        for (int i = 2; i <= Math.sqrt(maxVal); i++) {
            if(primes[i]==1){
                for(int j=i*i;j<=maxVal;j+=i)
                    primes[j]=0;
            }
        }

// Step 2: Create a prefix sum array
        // to count primes up to each number
        int[] primeCount = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            primeCount[i] = primeCount[i - 1];
            if (primes[i]==1) {
                primeCount[i]++;
            }
        }


        List<Integer>res=new ArrayList<>();
        for(List<Integer> query: queries){
            int start=query.get(0);
            int end=query.get(1);
            if (start == 0) {
                res.add(primeCount[end]);
            } else {
                res.add(primeCount[end] - primeCount[start - 1]);
            }
        }
        return res;
    }
}
