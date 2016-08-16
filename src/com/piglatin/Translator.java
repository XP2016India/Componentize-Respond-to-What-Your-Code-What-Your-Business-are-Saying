package com.piglatin;

import java.util.ArrayList;
import java.util.List;

public class Translator {
	// Organize activities into classes and develop understanding about design.
	private VowelRule vowelRule = new VowelRule();
	private QUClusterRule quCluster = new QUClusterRule();
	private ConsonantRule consonantRule = new ConsonantRule();
	
	// Refactor the Rules to a common interface so we can simplify below code.
	public String translate(String string) {				
		if(vowelRule.attemptRule(string)) return vowelRule.getPigLatinWord(); 
		else if(quCluster.attemptRule(string)) return quCluster.getPigLatinWord();
		else {
			consonantRule.attemptRule(string);
			return consonantRule.getPigLatinWord();
		}	
	}
}