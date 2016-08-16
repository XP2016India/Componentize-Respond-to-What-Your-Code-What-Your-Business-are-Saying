package com.piglatin.rulesandcheckers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class ConsonantRuleTest {
	private ConsonantRule rule;

	@Before
	public void initialize() {
		rule = new ConsonantRule();
	}

	@Test
	public void testGetPigLatinWordInitialized() {
		assertThat(rule.getPigLatinWord(), is(nullValue()));
	}

	@Test
	public void testAttemptRule() {
		rule.attemptRule("hello");
		assertThat(rule.getPigLatinWord(), is("ellohay"));
	}
}
