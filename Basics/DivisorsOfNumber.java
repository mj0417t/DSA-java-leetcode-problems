class DivisorsOfNumber{
    public static void printDivisors(int n){
        if(n==0) return;
        int sqrt = (int)Math.sqrt(n);
        for(int i=1;i<=sqrt;i++){

            if(n%i == 0){
                if(i==sqrt){
                    System.out.print(i);
                }else{
                    System.out.print(i+", "+n/i+", ");
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("The divisors of N are ");
        printDivisors(0);
        printDivisors(72);
        printDivisors(99);
    }
}