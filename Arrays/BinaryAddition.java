//Given two binary strings a and b, return their sum as a binary string.
import java.util.ArrayList;
import java.util.Collections;

class BinaryAddition{
	
	static StringBuilder result = new StringBuilder();
	static int carry=0;
	
	static void updateResult(char x, char y){
		
		if(x=='0' && y=='0'){
			if(carry==1){
				result.append('1');
				carry=0;
			}else{
				result.append('0');
			}
		}
		if(x=='0' && y=='1'){
			if(carry==1){
				result.append('0');
				carry=1;
			}else{
				result.append('1');
			}
		}
		if(x=='1' && y=='0'){
			if(carry==1){
				result.append('0');
				carry=1;
			}else{
				result.append('1');
			}
		}
		if(x=='1' && y=='1'){
			if(carry==1){
				result.append('1');
				carry=1;
			}else{
				result.append('0');
				carry=1;
			}
		}
	}
	
	static void checkAndUpdateResult(char[] ch, int i){
		while(i>=0){
					if(ch[i]=='1' && carry==1){
						result.append('0');
						carry=1;
					}else if(ch[i]=='0' && carry==1){
						result.append('1');
						carry=0;
					}else{
						result.append(ch[i]);
					}
					i--;
				}
	}
	
	public static void main(String args[]){
		String a="1010";
		String b="1011";
		char[] ch_a=a.toCharArray();
		char[] ch_b=b.toCharArray();
		
		int m=a.length(),n=b.length();
		
		
		
		if(m==n){
			for(int i=n-1;i>=0;i--)
				updateResult(ch_a[i],ch_b[i]);
			
		}else{
			int i=m-1,j=n-1;
			for(;i>=0 && j>=0;i--,j--){
				updateResult(ch_a[i],ch_b[j]);
			}
			if(i>=0){
				checkAndUpdateResult(ch_a,i);
			}else if(j>=0){
				checkAndUpdateResult(ch_b,j);
			}
			
		}
		
		if(carry==1){
				result.append('1');
			}
			
			System.out.printf("Result: "+ result.reverse().toString());
	}
}