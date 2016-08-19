# componentize
Versions of a Pig Latin translator for a workshop on componentizing functionality.
You'll see tags used to present to you different stages: initial_mess, seperate_classes, common_interfaces, and finally discovery.

initial_mess is the stage that most people stay at.  Here they keep growing the code by adding functionality into the Translator class.  Month by month, this class gets more if elses, or become converted to a switch statement.

seperate_classes is the first step in refactoring where refactorings such as extract a method and create class are used to break the funnctionality into seperate methods.  This is a good first step but doesn't reach the promise of componetization: the ability to add new functionality by simply adding a new class, thereby, scaling our design with our functionality.

common_interfaces is the next step to deciding what activities are common across our translation rules.  Now it's clear that new functionality can be added by creating a Checker class and Rule class.  However we still have that array in the Translator that needs to be updated whenever more translation functionality is added.  This code grows in a scalable way except for that line of code.

discovery here we use "replace algorithim" refactoring and replace the array declration with two static finctions that use Reflection to inspect the classpath for TranslationRuleable classes, then dynamically create the list at runtime.  I also discover i needed to add to my common interface to force ConsonentRule to be executed last.  My unit tests told me this by giving me bad news.

Here are the static functions, authored by Victor Tatai.  It seemed like the least complex code to use. ( https://dzone.com/articles/get-all-classes-within-package)  Other alternatives:
	https://github.com/lukehutch/fast-classpath-scanner
	https://github.com/ronmamo/reflections
	  
	Use annotations: http://stackoverflow.com/questions/259140/scanning-java-annotations-at-runtime   There you'll see Spring or Java Annotations strategies.
	It turns out that built in Java Reflections doesn't easily do this for you and you actually have to do the work. :-)
	 
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
