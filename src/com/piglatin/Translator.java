package com.piglatin;

import java.util.Arrays;
import java.util.List;

public class Translator {

	public String translate(String englishWord) {	
		if ( (englishWord.charAt(0)== 'q' && englishWord.charAt(1) == 'u'))	{
			return (englishWord.substring(2,  englishWord.length()) + englishWord.substring(0, 2) + "ay");
		}
		else  if (isStartsWithVowel(englishWord) ){	
				return (englishWord + "ay");
		}	else	{
		 return (englishWord.substring(1, englishWord.length()) + englishWord.substring(0, 1) + "ay");
		}
	}

	final List <Character> vowels = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'});
	private boolean isStartsWithVowel(String englishWord) {
			if (vowels.contains(englishWord.charAt(0))) return true;
		return false;
	}
}
