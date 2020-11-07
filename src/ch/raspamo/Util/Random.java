package ch.raspamo.Util;

public class Random {
    public static int randInt(int min, int max) {
        java.util.Random r = new java.util.Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
