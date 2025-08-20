package example.interview.questions;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		PalindromeNumber.palindromNumber(1221);

	}

	public static void palindromNumber(int number){

		int remainder, sum=0, temp=number;
		
		while(number>0) {
			
			remainder = number%10;
			sum=sum*10+remainder;
			System.out.println("Sum :"+sum);
			
			number=number/10;
			
		}
		if(sum==temp) 
			System.out.println("Palindrom number");
		
		else
			System.out.println("Not a palindrom number");
	}
}
