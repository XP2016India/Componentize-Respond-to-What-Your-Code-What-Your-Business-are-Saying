package com.piglatin.rulesandcheckers;

public class ConsonantRule implements TranslationRuleable {
	private String pigLatinWord;

	@Override
	public boolean isToExecuteLast(){return true;}
	
	@Override
	public String getPigLatinWord() {
		return pigLatinWord;
	}

	@Override
	public boolean attemptRule(String englishWord) {		
		pigLatinWord = englishWord.substring(1, englishWord.length())
				+ englishWord.charAt(0) + "ay";
		return true;
	}
}