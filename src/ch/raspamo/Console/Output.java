package ch.raspamo.Console;

public class Output {
    public static void print(String message, String color) {
        System.out.print(color + message + Colors.ANSI_RESET);
    }

    public static void println(String message, String color) {
        print(message + "\n", color);
    }

    public static void print(String message) {
        print(message, Colors.ANSI_WHITE);
    }

    public static void println(String message) {
        println(message, Colors.ANSI_WHITE);
    }

    public static void println() { println(""); }

    public static void subtitle(String message, String color) {
        println(message, color);
        printSeperator(message, color);
    }

    public static void subtitle(String message) {
        subtitle(message, Colors.ANSI_CYAN);
    }

    public static void title(String message, String color) {
        int paddedLength = message.length() + 6;
        String padding = "++ ";
        for (int i = 0; i < message.length(); i++) {
            padding += " ";
        }
        padding += " ++";

        printSeperator(paddedLength, color, '+');
        println(padding, color);
        println("++ " + message + " ++", color);
        println(padding, color);
        printSeperator(paddedLength, color, '+');
        println("");
        println("");
    }

    public static void title(String message) {
        title(message, Colors.ANSI_PURPLE);
    }

    public static void printSeperator(int length, String color, Character character) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output += character;
        }

        println(output, color);
    }

    public static void printSeperator(String message, String color, Character character) {
        printSeperator(message.length(), color, character);
    }

    public static void printSeperator(int length, String color) {
        printSeperator(length, color, '=');
    }

    public static void printSeperator(String message, String color) {
        printSeperator(message.length(), color);
    }

    public static void printSeperator(int length) {
        printSeperator(length, Colors.ANSI_WHITE);
    }

    public static void printSeperator(String message) {
        printSeperator(message.length(), Colors.ANSI_WHITE);
    }
}
