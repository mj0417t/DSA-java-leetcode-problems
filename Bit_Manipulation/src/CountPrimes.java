public class CountPrimes {
    public static void main(String[] args) {
        int n=10;
//        System.out.println(countPrimes(n));
        System.out.println(countPrimesOpt(n)); // using sieve of eratosthenes
    }

    private static int countPrimesOpt(int n) {
        int[] primes=new int[n+1];
        for (int i = 2; i <=n; i++)
            primes[i]=1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(primes[i]==1){
                for(int j=i*i;j<=n;j+=i)
                    primes[j]=0;
            }
        }
        int cnt=0;
        for (int i = 2; i < n; i++) {
            if(primes[i]==1)
                cnt++;
        }
        return cnt;
    }

    static int countPrimes(int n) {
        int cnt=0;
        for (int i = 2; i < n; i++) {
            if(checkPrime(i))
                cnt++;
        }
        return cnt;
    }

    private static boolean checkPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) {
               return false;
            }
        }
        return true;
    }
}
