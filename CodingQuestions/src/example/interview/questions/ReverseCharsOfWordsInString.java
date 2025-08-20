package example.interview.questions;

public class ReverseCharsOfWordsInString {

	public static void main(String[] args) {
		
		String name="Bhagya Lakshmi Manvi";
		ReverseCharsOfWordsInString.reverseCharsOfWordsInString(name);

	}
	
	//(I/p "Arun kumar reddy"  O/P "nurA ramuk ydder")
	public static void reverseCharsOfWordsInString(String name) {
		
		StringBuilder reversedString=new StringBuilder();
		String[] split = name.split(" ");
		for(String word:split) {
			StringBuilder reversedWord=new StringBuilder(word);
			System.out.println(word);
			reversedString.append(reversedWord.reverse().toString()).append(" ");
			
		}
		
		System.out.println(reversedString);
	}

}
