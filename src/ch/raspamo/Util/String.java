package ch.raspamo.Util;

public class String {
    public static java.lang.String padRight(java.lang.String text, Integer length) {
        StringBuilder output = new StringBuilder(text);

        for (int i = text.length(); i < length; i++) {
            output.append(" ");
        }

        return output.toString();
    }
}
