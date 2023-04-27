package rpn.regex;

public class Regex {
	
	public static boolean isNum(String token) {
		String integer = "^[-]?[1-9][0-9]*|0$";
		String floating = "^[-]?([1-9][0-9]*|0)[.][0-9]+$";
		return token.matches(integer + "|" + floating);
	}
	
	public static boolean isOP(String token) {
		String ops = "[\\^*/+\\-]";
		return token.matches(ops);
	}

}
