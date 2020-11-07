package ch.raspamo.Exercises;

import ch.raspamo.Callable;
import ch.raspamo.Console.Colors;
import ch.raspamo.Console.Output;
import ch.raspamo.Console.ProgressBar;
import ch.raspamo.Console.Table;
import ch.raspamo.Exception.ExerciseExeption;
import ch.raspamo.State;
import ch.raspamo.Util.Random;

public class Hausaufgabe01 implements Callable {
    @Override
    public void call() throws ExerciseExeption {
        State state = State.getState();

        String[] args = state.getArgs();

        if (args.length > 0) {
            Table.print(args, "Argumente");
        }
        else {
            Output.println("Keine Argumente vorhanden!", Colors.ANSI_RED);
        }
    }
}
