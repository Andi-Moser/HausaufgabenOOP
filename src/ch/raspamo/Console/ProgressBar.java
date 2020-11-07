package ch.raspamo.Console;

import java.text.DecimalFormat;

public class ProgressBar {
    private int maxValue;
    private int currentValue;

    private DecimalFormat decimalFormat = new DecimalFormat();

    private int width = 40;

    public ProgressBar(String title, int max) {
        maxValue = max;
        currentValue = 0;

        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);

        Output.println(title);
        printProgress();
    }

    public void progress(int step) {
        if (currentValue + step > maxValue) {
            end();
        }
        else {
            currentValue += step;
            printProgress();
        }
    }

    public void progress() {
        progress(1);
    }

    public void end() {
        Output.println("");
    }

    private void printProgress() {
        String output = "";
        String progress = "";

        float percentage = (currentValue * 100.0f / maxValue);

        // build the format string
        for (int i = 1; i < width; i++) {
            float percentageTile = (100.0f / width) * i;

            if (percentageTile > percentage) {
                // not done yet
                progress += " ";
            }
            else {
                // Done, but determine if its the last one which is done
                float percentageOfNextTile = (100.0f / width) * (i + 1);

                if (percentageOfNextTile > percentage) {
                    // its the last one
                    progress += ">";
                }
                else {
                    progress += "=";
                }
            }
        }

        output = "\r[" + progress + "] " + decimalFormat.format(percentage) + "%";

        //Output.println(currentValue + "/" + maxValue + "  " + percentage + "%");
        Output.print(output);
    }
}
