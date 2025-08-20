package example.interview.questions;

public class PrimeNumber {

	public static void main(String[] args) {
		
		int number=7;
		//for(int i=1;i<30;i++) {
		if(PrimeNumber.primeNumber(number)) {
			System.out.println("Prime number");
	//	}
		}
		else
			System.out.println("Not a prime number");

	}
	
	public static boolean primeNumber(int number) {
		
		if(number<=1)
			return false;
		
		for(int i=2;i<number/2;i++) {
			if(number%i==0)
				return false;
		}
		return true;
	}

}
