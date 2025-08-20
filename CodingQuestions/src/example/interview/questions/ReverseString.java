package example.interview.questions;

public class ReverseString {

	/*//using StringBuffer
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("SEELA HARI");

		sb.reverse();

		System.out.println("Reversed string :" + sb);

	}*/
	
	
	//Using loops
	public static void main(String[] args) {
		
		ReverseString.reverseString("SEELA HARI");

	}
	public static void reverseString(String name){

		String reverse = "";

		for(int i=0; i<name.length(); i++){

			reverse = name.charAt(i)+reverse;

		}

		System.out.println("Reversed String :" + reverse);

	}
}
