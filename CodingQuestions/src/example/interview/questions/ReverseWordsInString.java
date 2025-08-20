package example.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReverseWordsInString {

	public static void main(String[] args) {
		
		String name = "Arun kumar reddy";

		System.out.println(reverseWordsInString(name));
		

	}

	//I/p "Arun kumar reddy"  O/P "nurA ramuk ydder"
	public static String reverseWordsInString(String name) {
		
		List<String> words=new ArrayList<String>();
		String[] split=name.split(" ");
		for(String word:split) {
			words.add(word);
		}
		
		Collections.reverse(words);
		return name.join(" ", words);
	}
}
