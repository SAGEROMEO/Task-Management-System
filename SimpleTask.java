public final class SimpleTask extends Task
{

    public SimpleTask(int id, String description, int priority, String dueDate)
    {
        super(id, description,priority , dueDate);

        if(priority <= 7)
        {
            System.out.println("\nSimple task priority should be between 7 - 10, reassign!");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("\nSimple Task: " + getDescription() + "\nPriority: " + getPriority());
    }
}
