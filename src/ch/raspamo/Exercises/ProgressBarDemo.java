package ch.raspamo.Exercises;

import ch.raspamo.Callable;
import ch.raspamo.Console.ProgressBar;
import ch.raspamo.Exception.ExerciseExeption;
import ch.raspamo.Util.Random;

public class ProgressBarDemo implements Callable {
    @Override
    public void call() throws ExerciseExeption {
        try {
            int max = 500;
            ProgressBar bar = new ProgressBar("Computing...", max);
            for (int i = 0; i < max; i++) {
                bar.progress();
                Thread.sleep(Random.randInt(10, 100));
            }
        }
        catch (InterruptedException e) {
            throw new ExerciseExeption(e.getMessage());
        }
    }
}
