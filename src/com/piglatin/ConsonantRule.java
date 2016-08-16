package com.piglatin;

public class ConsonantRule {
	private String pigLatinWord;

	public String getPigLatinWord() {
		return pigLatinWord;
	}

	public boolean attemptRule(String englishWord) {
		pigLatinWord = englishWord.substring(1, englishWord.length())
				+ englishWord.charAt(0) + "ay";
		return true;
	}
}
