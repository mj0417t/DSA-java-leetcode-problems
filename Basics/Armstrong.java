public class Armstrong {

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(371));
        System.out.println(isArmstrong(1634));
        System.out.println(isArmstrong(723));
        System.out.println(isArmstrong(0));
        System.out.println(isArmstrong(9));

    }

    public static boolean isArmstrong(int num){
       /* if(num==0) return true;
        int temp=num, digit=0;
        while(temp!=0){
            digit++;
            temp/=10;
        }
        if(digit==1) return  true;
        */
        int temp=num;
        int digit = String.valueOf(num).length();
        int arm_num=0;
        while(temp!=0){
            int rem=temp%10;
            arm_num+=Math.pow(rem,digit);
            temp/=10;
        }

        if(num==arm_num) return true;
        return  false;
    }
}
