package com.piglatin.rulesandcheckers;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class VowelCheckerTest {

	VowelChecker checker;
	
	@Before
	public void initialize()
	{
		checker = new VowelChecker();
	}
	
	@Test
	public void isVowelIdentifiesAllVowels()
	{
		assertThat(checker.isVowel(new char[]{'a'}), is(true));
		assertThat(checker.isVowel(new char[]{'e'}), is(true));
		assertThat(checker.isVowel(new char[]{'i'}), is(true));
		assertThat(checker.isVowel(new char[]{'o'}), is(true));
		assertThat(checker.isVowel(new char[]{'u'}), is(true));
	}
	
	@Test
	public void isVowelIdentifiesConsonants()
	{
		char [] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
		final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
		//assertThat(consonants.length, is(NUMBER_OF_LETTERS_IN_ALPHABET - VowelChecker.NUMBER_OF_VOWELS));
		
		for (char letter : consonants) {
			assertThat(checker.isVowel(new char[] {letter}), is(false));
		}
	}
}
