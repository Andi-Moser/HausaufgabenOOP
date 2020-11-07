package ch.raspamo.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class Choice {
    public static int askChoice(String question, ArrayList<String> options) {
        while (true) {
            Output.subtitle(question);
            int currentChoice = 0;

            for (String choice : options) {
                Output.println("  [" + currentChoice + "] " + choice);
                currentChoice++;
            }

            Output.println("");
            Output.println("Please enter the number of your choice");
            Output.println("");

            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int selection = input.nextInt();

                if (selection >= 0 && selection < options.size()) {
                    return selection;
                }
            }
            else {
                Output.println("Option " + input.next() + " does not exist.", Colors.ANSI_RED);
            }
        }
    }
}
