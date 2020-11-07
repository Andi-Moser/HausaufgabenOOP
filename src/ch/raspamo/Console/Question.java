package ch.raspamo.Console;

import java.util.Scanner;

public class Question {
    public static int askInt(String message) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
        }
    }
}
