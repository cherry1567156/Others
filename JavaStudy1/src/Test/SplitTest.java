 package Test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitTest {
	//\\\\|/|:|[*]|[?]|\"|<|>|[|]
	//\\\\\\$\\(\\)\\*\\+\\.\\[\\]\\?\\^\\{\\}\\|
	private static final Pattern pa = Pattern.compile("\\\\|\\||\\^|\\*|\\?|\\.|\\{|\\}|\\[|\\]");
	public static void main(String[] args) {
		String aString="a#b#c#d";
		String bString="a|||b|||c|||d";
		String arry[]=aString.split("#");
		String brry[]=bString.split("\\|\\|\\|");
		String specialChar = "|+*^$/|[]()-.\\";
		String splitObject = "|||";
		String aString2=splitObject.replaceAll("|", "\\\\|");
		//System.out.println(splitObject);
		//System.out.println(splitObject.replaceAll("\\|", "\\\\|"));
		test();
	}
	public static void test() {
		String replacement="\\";
		String splitObject ="|||||$()*+.[]?{}|";
		System.out.println(splitObject);
		char[] specialChar = { '\\', '$', '(', ')', '*', '+', '.', '[', ']', '?', '^', '{', '}', '|' };
		for (char key : specialChar) {
			if (splitObject.indexOf(key)!=-1) {
				splitObject = splitObject.replace(String.valueOf(key), "\\"+key);
			}
		}
		System.out.println(splitObject);
	}
}
