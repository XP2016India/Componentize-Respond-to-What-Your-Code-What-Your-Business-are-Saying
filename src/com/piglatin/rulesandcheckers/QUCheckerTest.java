package com.piglatin.rulesandcheckers;

import static org.junit.Assert.*;

import org.junit.Test;

public class QUCheckerTest {

	@Test
	public void isQU_detectsStartsWithQU()
	{
		QUChecker checker = new QUChecker();
		assertEquals(checker.isQU("qu".toCharArray()), true);
	}
	
	@Test
	public void isQU_detectsNoQU()
	{
		QUChecker checker = new QUChecker();
		assertEquals(checker.isQU("hh".toCharArray()), false);
	}
}
