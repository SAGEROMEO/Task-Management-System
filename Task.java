import java.util.Map;
import java.util.TreeMap;

public sealed abstract class Task permits SimpleTask, ScheduledTask {

    private int id;
    private String description;
    private User assignedUser;
    private String dueDate;
    private int priority;  //lower number = higher priority

    public Task(int id, String description, int priority,String dueDate) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Task(int id, String description) {
        this.id =id;
        this.description =description;
    }

    public Task() {

    }


    // Abstract method
    public abstract void displayDetails();

    // Assign user
    public void assignUser(User user) {
        this.assignedUser = user;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    // Setters
    public void setId(int id) { this.id = id; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }



    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString()
    {
        return  "Id: " + getId() + " - Task: " + description + " - Priority level: " + priority;
    }

}
