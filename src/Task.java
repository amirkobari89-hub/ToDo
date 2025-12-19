public class Task {

    private String title;
    private int priority;
    private boolean done;

    public Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    public void toggleDone() {
        done = !done;
    }
}
