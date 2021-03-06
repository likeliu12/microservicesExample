package basic.patternReg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestPatternMatcher {
	public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(\\w+)\\s+(\\w+)");
		// In case you would like to ignore case sensitivity you could use this
		// statement
		// Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		// Check all occurance
		while (matcher.find()) {
			System.out.println("Start index: " + matcher.start());
			System.out.println(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group(1) + "    " + matcher.group(2));
		}
//		matcher = pattern.matcher(EXAMPLE_TEST);
		while (matcher.find()) {
			System.out.println("shoud not happen ");			
		}
		// Now create a new pattern and matcher to replace whitespace with tabs
		Pattern replace = Pattern.compile("\\s+");
		Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
		System.out.println(matcher2.replaceAll("\t"));
	}
}