package com.piglatin.rulesandcheckers;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QUClusterRuleTest {
	private QUClusterRule rule;
	
	@Before
	public void initialize()
	{
		rule = new QUClusterRule();
	}
	
	@Test
	public void translateForQUCluster() {
		rule.attemptRule("quote");
		assertThat(rule.getPigLatinWord(), is("otequay"));
	}
}
