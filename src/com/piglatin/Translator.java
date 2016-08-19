package com.piglatin;

import com.piglatin.rulesandcheckers.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.piglatin.rulesandcheckers.TranslationRuleable;
import com.piglatin.rulesandcheckers.VowelRule;

public class Translator {
	// Refactored to enable feature discovery at runtime.
	private TranslationRuleable[] rules;

	public Translator() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// Don't need the below old code using the "Replace Algorithim" refactoring.
		// rules = new TranslationRuleable [] {new VowelRule(), new QUClusterRule(), new ConsonantRule()};
		try {
			loadRules();
		} catch (IllegalAccessException | ClassNotFoundException | IOException problemDuringDiscovery) {
			throw new InstantiationException(problemDuringDiscovery.getMessage());
		}
	}

	void loadRules() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		List<TranslationRuleable> ruleables = new ArrayList<TranslationRuleable>();
		TranslationRuleable lastRule = null;
		
		for (Class aClass : getClasses("com.piglatin.rulesandcheckers")) {
			for(Class anInterface : aClass.getInterfaces()) if (anInterface.getName().equals(TranslationRuleable.class.getName())){ 
				TranslationRuleable aRule = (TranslationRuleable) aClass.newInstance();
				if(aRule.isToExecuteLast() == true) lastRule = aRule;
				else 	ruleables.add((TranslationRuleable) aClass.newInstance());
				}
		}
		ruleables.add(lastRule);
		rules = new TranslationRuleable[ruleables.size()];
		rules = ruleables.toArray(rules);
	}

	/** The next two static functions were copy/pasted from: by Victor Tatai https://dzone.com/articles/get-all-classes-within-package
	* Other alternatives: https://github.com/lukehutch/fast-classpath-scanner
	*  https://github.com/ronmamo/reflections
	*  
	*  Use annotations: http://stackoverflow.com/questions/259140/scanning-java-annotations-at-runtime   There you'll see Spring or Java Annotations
	*  strategies.
	*  
	*  It turns out that built in Java Reflections doesn't easily do this for you and you actually have to do the work. :-)
	*/ 
	private static Class[] getClasses(String packageName)
			throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList classes = new ArrayList();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return (Class[]) classes.toArray(new Class[classes.size()]);
	}

	private static List findClasses(File directory, String packageName)
			throws ClassNotFoundException {
		List classes = new ArrayList();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file,
						packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName
						+ '.'
						+ file.getName().substring(0,
								file.getName().length() - 6)));
			}
		}
		return classes;
	}

	public String translate(String englishWord) {
		if (englishWord.length() < 1)
			return "";
		for (TranslationRuleable rule : rules) {
			if (rule.attemptRule(englishWord))
				return rule.getPigLatinWord();
		}
		throw new IllegalStateException("no TranslationRuleable was applied.");
	}
}