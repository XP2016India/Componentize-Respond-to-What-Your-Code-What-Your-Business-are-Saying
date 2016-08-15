package com.piglatin;

import java.util.Arrays;
import java.util.List;

public class Translator {
	final Character [] vowels = new Character[]{'a','u','e','i','o'};
	final List <Character> vowelsList = Arrays.asList(vowels);

	public String translate(String englishWord) {	
		
		int vowelPosition = -1;
		if ( (englishWord.charAt(0)== 'q' && englishWord.charAt(1) == 'u'))	{
			
			return (englishWord.substring(2,  englishWord.length()) + englishWord.substring(0, 2) + "ay");
		}
		else  if (isStartsWithVowel(englishWord) ){	
			
				return (englishWord + "ay");
		}	else	{
		 return (englishWord.substring(1, englishWord.length()) + englishWord.substring(0, 1) + "ay");
		}
		
	}

	private boolean isStartsWithVowel(String englishWord) {
			if (vowelsList.contains(englishWord.charAt(0))) return true;
		return false;
	}
}
