package com.piglatin.rulesandcheckers;

import static org.junit.Assert.*;

import org.junit.*;

public class VowelRuleTest {
	private VowelRule rule;
	
	@Before
	public void initialize()
	{
		rule = new VowelRule();
	}
	
	@Test
	public void translateForVowel() {
		rule.attemptRule("apple");
		assertEquals("appleay",rule.getPigLatinWord());
		
		rule.attemptRule("elephant");
		assertEquals("elephantay",rule.getPigLatinWord());
		
		rule.attemptRule("umbrella");
		assertEquals("umbrellaay",rule.getPigLatinWord());
		
		rule.attemptRule("igloo");
		assertEquals("iglooay",rule.getPigLatinWord());
		
		rule.attemptRule("opal");
		assertEquals("opalay",rule.getPigLatinWord());
	}
}
