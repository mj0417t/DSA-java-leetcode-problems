public class NumberToWords {
    // write code here
    public static int reverse(int num){
        int reverse=0;
        while(num!=0){
            int rem=num%10;
            reverse=reverse*10+rem;
            num/=10;
        }
        return reverse;
    }
    
    public static int getDigitCount(int num){
        if(num<0) return -1;
        if(num==0) return 1;
        int count=0;
        while(num!=0){
            count++;
            num/=10;
        }
        return count;
    }
    
    public static void numberToWords(int num){
        if(num<0) System.out.println("Invalid Value");
        else if(num==0) System.out.println("Zero");
        else{
            int numDigitCount=getDigitCount(num);
            int rev=reverse(num);
            int revDigCount=getDigitCount(rev);
            while(rev!=0){
                int digit =rev%10;
                switch(digit){
                    case 0:
                        System.out.println("Zero");
                        break;
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                }
                rev/=10;
            }
            while(revDigCount!=numDigitCount){
            System.out.println("Zero");
            revDigCount++;
            }
        
        }
    }
	
	public static void main(String[] args){
		numberToWords(123430020);
	}
}