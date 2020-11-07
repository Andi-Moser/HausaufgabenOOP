package ch.raspamo;

import ch.raspamo.Console.Choice;
import ch.raspamo.Console.Colors;
import ch.raspamo.Console.Output;
import ch.raspamo.Console.ProgressBar;
import ch.raspamo.Exception.IllegalCallableException;
import ch.raspamo.Util.Random;

import javax.print.URIException;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            State state = State.getState();
            state.setArgs(args);

            Output.title("Andis Hausaufgaben Tool - v0.1");
            ArrayList<String> callables = loadAndVerifyCallables();

            int choice = Choice.askChoice("Select the class you want to start", callables);

            String className = callables.get(choice);

            Output.subtitle("Start Program " + className, Colors.ANSI_RED);

            Class<?> selectedClass = Class.forName("ch.raspamo.Exercises." + className);

            Callable instance = (Callable)selectedClass.newInstance();
            instance.call();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.print(e.getStackTrace());
        }
    }

    private static ArrayList<String> loadAndVerifyCallables() throws IllegalCallableException, Exception {
        //TODO: Read callables dynamically
        ArrayList<String> checkedCallables = new ArrayList<String>();

        Collection<File> allFiles = new ArrayList<File>();
        try {
            String rootPath = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            File rootFolder = new File(rootPath + "/ch/raspamo/Exercises");
            File[] children = rootFolder.listFiles();

            if (children != null) {
                for (int i = 0; i < children.length; i++) {
                    File child = children[i];
                    String fileName = child.getName();
                    String className = fileName.replace(".class", "");
                    try {
                        Class<?> classDefinition = Class.forName("ch.raspamo.Exercises." + className);

                        if (Callable.class.isAssignableFrom(classDefinition)) {
                            checkedCallables.add(className);
                        }
                    }
                    catch (Exception e) {
                        IllegalCallableException error = new IllegalCallableException("Registered callable " + className + " is not found in namespace");

                        throw error;
                    }
                }
            }
        }
        catch (URISyntaxException e) {
            throw new Exception("Could not read source path");
        }

        return checkedCallables;
    }
}
