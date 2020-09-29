package utils;

public class MyStringUtils {
	public static String repeat(String element, int length) {
		String result = "";
		for(int i = 0; i < length; i++) {
			result+= element;
		}
		return result;
	}
	public static String centre(String text, int length) {
		String out = String.format("%"+length+"s%s%"+length+"s", "",text,"");
		float mid = (out.length()/2);
		float start = mid - (length/2);
		float end = start + length;
		return out.substring((int)start, (int)end);
	}
}
