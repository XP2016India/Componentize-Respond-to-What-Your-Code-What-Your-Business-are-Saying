package com.piglatin;

import java.util.ArrayList;
import java.util.List;

public class Translator {
	private VowelRule vowelRule = new VowelRule();
	private QUClusterRule quCluster = new QUClusterRule();
	private ConsonantRule consonantRule = new ConsonantRule();
	
	public String translate(String string) {				
		if(vowelRule.attemptRule(string)) return vowelRule.getPigLatinWord(); 
		else if(quCluster.attemptRule(string)) return quCluster.getPigLatinWord();
		else {
			consonantRule.attemptRule(string);
			return consonantRule.getPigLatinWord();
		}	
	}
}