package com.piglatin.rulesandcheckers;


public class VowelRule implements TranslationRuleable{
	@Override
	public boolean isToExecuteLast() {return false;	}
	
	private VowelChecker vowelChecker = new VowelChecker();;
	private String pigLatinWord;

	@Override
	public String getPigLatinWord() {
		return pigLatinWord;
	}

	@Override
	public boolean attemptRule(String englishWord) {
		if (vowelChecker.isVowel(new char[] { englishWord.charAt(0) })) {
			pigLatinWord = new String(englishWord + "ay");
			return true;
		} else
			return false;
	}
}