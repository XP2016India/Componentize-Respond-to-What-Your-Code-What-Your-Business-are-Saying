package com.piglatin.rulesandcheckers;

public interface TranslationRuleable {
	public boolean isToExecuteLast();
	public String getPigLatinWord();
	public boolean attemptRule(String englishWord);
}