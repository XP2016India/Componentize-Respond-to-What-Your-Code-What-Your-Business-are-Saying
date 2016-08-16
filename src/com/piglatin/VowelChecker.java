package com.piglatin;

import java.util.Arrays;
import java.util.List;

public class VowelChecker {
	final private List<Character> vowels = Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u' });

	public boolean isVowel(char[] character) {
		return vowels.contains(character[0]);
	}
}
