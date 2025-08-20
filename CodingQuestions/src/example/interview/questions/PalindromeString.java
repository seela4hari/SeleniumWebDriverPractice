package example.interview.questions;

public class PalindromeString {

	public static void main(String[] args) {
		PalindromeString.palindromeString("Madam");
	}
	
	public static void palindromeString(String name) {
		
		String reverse="";
		for(int i=0;i<name.length();i++) {
			
			reverse=name.charAt(i)+reverse;
			
		}
		if (reverse.equalsIgnoreCase(name))
		System.out.println("palindrome string");
		else
			System.out.println("Not a palindrome string");
	}

}
