package com.piglatin;

public class VowelRule {
	private VowelChecker vowelChecker;
	private String pigLatinWord;

	public String getPigLatinWord() {
		return pigLatinWord;
	}

	public VowelRule() {
		this.vowelChecker = new VowelChecker();
	}

	public boolean attemptRule(String englishWord) {
		if (vowelChecker.isVowel(new char[] { englishWord.charAt(0) })) {
			pigLatinWord = new String(englishWord + "ay");
			return true;
		} else
			return false;
	}
}