package ch.raspamo.Console;

import ch.raspamo.Util.String;

import java.awt.*;

public class Table {
    public static void print(java.lang.String[] elements, java.lang.String title, Boolean showTotalCount) {
        Output.println();
        Output.print(title, Colors.ANSI_PURPLE);
        Output.println();
        if (showTotalCount) {
            Output.println("Anzahl Einträge: " + elements.length);
        }

        // determine the max size of any element
        int maxElementSize = 0;
        for (int i = 0; i < elements.length; i++) {
            java.lang.String element = elements[i];

            if (element.length() > maxElementSize) {
                maxElementSize = element.length();
            }
        }

        // determine how many digits we will use for the incremental number
        int sizeForFirstColumn = (int) (Math.log10(elements.length) + 1);

        // get the total width
        int totalWidth = 7 + maxElementSize + sizeForFirstColumn;

        Output.printSeperator(totalWidth, Colors.ANSI_WHITE, '-');

        // get the headLine
        StringBuilder headline = new StringBuilder("| ");
        headline.append(String.padRight("#", sizeForFirstColumn));
        headline.append(" | ");
        headline.append(String.padRight("Element", maxElementSize));
        headline.append(" |");

        Output.println(headline.toString());
        StringBuilder seperator = new StringBuilder();
        for (int i = 0; i < totalWidth; i++) {
            if (i == 0 || i == (totalWidth-1)) {
                seperator.append("|");
            }
            else if (i == (sizeForFirstColumn + 3)) {
                seperator.append("+");
            }
            else {
                seperator.append("-");
            }
        }
        Output.println(seperator.toString());

        for (int i = 0; i < elements.length; i++) {
            java.lang.String element = elements[i];

            StringBuilder output = new StringBuilder();
            output.append("| ");
            output.append(String.padRight(java.lang.String.valueOf(i), sizeForFirstColumn));
            output.append(" | ");
            output.append(String.padRight(element, maxElementSize));
            output.append(" |");

            Output.println(output.toString());
        }

        Output.printSeperator(totalWidth, Colors.ANSI_WHITE, '-');
    }

    public static void print(java.lang.String[] elements, java.lang.String title) {
        Table.print(elements, title, true);
    }
}
