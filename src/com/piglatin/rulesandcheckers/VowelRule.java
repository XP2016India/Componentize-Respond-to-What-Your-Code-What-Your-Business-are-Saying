package com.piglatin.rulesandcheckers;


public class VowelRule implements TranslationRuleable{
	private VowelChecker vowelChecker = new VowelChecker();;
	private String pigLatinWord;

	public String getPigLatinWord() {
		return pigLatinWord;
	}

	public boolean attemptRule(String englishWord) {
		if (vowelChecker.isVowel(new char[] { englishWord.charAt(0) })) {
			pigLatinWord = new String(englishWord + "ay");
			return true;
		} else
			return false;
	}
}