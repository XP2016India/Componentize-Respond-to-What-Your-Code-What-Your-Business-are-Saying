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
	}
}
