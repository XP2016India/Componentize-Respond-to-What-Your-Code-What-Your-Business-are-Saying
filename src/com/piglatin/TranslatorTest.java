package com.piglatin;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sun.javafx.geom.transform.CanTransformVec3d;

public class TranslatorTest {
	private Translator translator;

	// if you're not familiar with this form of exception testing, see
	// http://confessionsofanagilecoach.blogspot.in/2016/05/exceptional-exception-handling-testing.html
	@Rule
	public ExpectedException exceptionPolicy = ExpectedException.none();

	@Before
	public void create() throws Throwable {
		translator = new Translator();
	}

	@Test
	public void translate_simpleTranslation() {
		assertEquals("ellohay", translator.translate("hello"));
	}

	@Test
	public void translate_emptyString() {
		assertEquals("", translator.translate(""));
		assertEquals("", translator.translate(new String()));
	}

	@Test
	public void translate_consonentRuleDoesntOverrideOtherRules() {
		assertEquals("ietquay", translator.translate("quiet"));
		assertEquals("appleay", translator.translate("apple"));
	}

	@Test
	public void translate_cantAccessRuleableBecamesInstantiationException()
			throws Throwable {
		exceptionPolicy.expect(InstantiationException.class);
				
			Translator cantAccessImplementation = new Translator() {
				@Override
				void loadRules() throws IllegalAccessException {
					throw new IllegalAccessException();
				}
			};
			cantAccessImplementation.translate("");
		}		
		
	@Test
	public void translate_missingRuleablesBecamesInstantiationException()
			throws Throwable {
		exceptionPolicy.expect(InstantiationException.class);
			Translator missingRuleableClasses = new Translator() {
				@Override
				void loadRules() throws ClassNotFoundException {
					throw new ClassNotFoundException();
				}
			};
			missingRuleableClasses.translate("");
		}
	
	@Test
	public void translate_IOExceptionBecamesInstantiationException()
			throws Throwable {
		exceptionPolicy.expect(InstantiationException.class);
			Translator missingRuleableClasses = new Translator() {
				@Override
				void loadRules() throws IOException {
					throw new IOException();
				}
			};
			missingRuleableClasses.translate("");
		}

}