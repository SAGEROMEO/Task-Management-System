public sealed class ScheduledTask extends Task implements Prioritizable permits TaskManager {

    private String dueDate;

    public ScheduledTask(int id, String description, String dueDate, int priority) {
        super(id, description,priority,dueDate);
    }

    public ScheduledTask() {

    }


    @Override
    public void displayDetails() {
        System.out.println("\nScheduled Task: " + getDescription() + "\nDue Date: " + dueDate + "\nPriority: " + getPriority());
    }

    @Override
    public int getPriorityLevel() {
        return getPriority();
    }
}
