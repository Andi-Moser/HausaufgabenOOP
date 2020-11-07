package ch.raspamo;

public class State {
    protected static State _instance;

    protected String[] args;

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return this.args;
    }

    public static State getState() {
        if (State._instance == null) {
            State._instance = new State();
        }

        return State._instance;
    }
}
