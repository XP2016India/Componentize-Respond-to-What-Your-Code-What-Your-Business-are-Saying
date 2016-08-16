package com.piglatin;
import com.piglatin.rulesandcheckers.*;

import java.util.ArrayList;
import java.util.List;

import com.piglatin.rulesandcheckers.TranslationRuleable;
import com.piglatin.rulesandcheckers.VowelRule;

public class Translator {
	// Refactored the Rules to a common interface so we can simplify below code.
	private TranslationRuleable [] rules = {new VowelRule(),  new QUClusterRule(), new ConsonantRule()};
	
	public String translate(String englishWord) {
		if(englishWord.length() < 1) return "";
		for(TranslationRuleable rule : rules) {
			if(rule.attemptRule(englishWord)) return rule.getPigLatinWord();
		}
		throw new IllegalStateException("no TranslationRuleable was applied.");
	}
}