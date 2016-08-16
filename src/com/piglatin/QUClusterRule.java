package com.piglatin;

public class QUClusterRule {
	QUChecker quChecker = new QUChecker();
	private String pigLatinWord;

	public String getPigLatinWord() {
		return pigLatinWord;
	}
	
	public boolean attemptRule(String englishWord) {
		if (quChecker.isQU(new char[] { englishWord.charAt(0), englishWord.charAt(1) })) {
			pigLatinWord = new String(englishWord.substring(2, englishWord.length()) + "quay");
			return true;
		} else return false;
	}
}
