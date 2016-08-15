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
		assertEquals("elephantay", translator.translate("elephant"));
		assertEquals("appleay", translator.translate("apple"));
		assertEquals("iglooay", translator.translate("igloo"));
		assertEquals("opalay", translator.translate("opal"));
		assertEquals("upay", translator.translate("up"));
	}
}
