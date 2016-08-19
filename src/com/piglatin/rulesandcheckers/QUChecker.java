package com.piglatin.rulesandcheckers;

public class QUChecker {
	
	public boolean isQU(char [] maybeQU)
	{
		return new String(maybeQU).equals("qu");
	}
	
	public boolean isRunLast() { return false;}
}
