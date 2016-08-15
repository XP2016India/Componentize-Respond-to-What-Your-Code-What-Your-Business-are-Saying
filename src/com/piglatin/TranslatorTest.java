package com.piglatin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TranslatorTest {
	private Translator translator;

	@Before
	public void create()
	{
		translator = new Translator();
	}
	
	@Test
	public void translate_simpleTranslation(){		
		assertEquals("ellohay", translator.translate("hello"));
		assertEquals("yebay", translator.translate("bye"));
	}
	
	@Test
	public void translate_startsWithQUCluster(){
		assertEquals("otequay", translator.translate("quote"));
		assertEquals("estionquay", translator.translate("question"));
	}
		
	@Test
	public void translate_startsWithVowel(){
		assertEquals("eay", translator.translate("e"));
		assertEquals("aay", translator.translate("a"));
		assertEquals("iay", translator.translate("i"));
		assertEquals("oay", translator.translate("o"));
		assertEquals("uay", translator.translate("u"));
	}
}
