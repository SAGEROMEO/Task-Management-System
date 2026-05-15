import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TaskManager<Task> manager = new TaskManager<>();

        User u1 = new User(1, "Alice");
        User u2 = new User(2, "Bob");

        manager.addUser(u1);
        manager.addUser(u2);

        Task t1 = new SimpleTask(101, "Read notes",9, " ");
        Task t2 = new ScheduledTask(102, "Submit project", "2026-04-20", 1);
        Task t3 = new ScheduledTask(103, "Prepare slides", "2026-04-18", 2);

        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);

        manager.assignTask(102, 1);
        manager.assignTask(103, 2);

        System.out.println("All Tasks: ");
        manager.displayTasks();

        System.out.println("Sorted by Priority: ");
        manager.displayTasksByPriority();

        manager.FilterTasksByPriorityLevel(5);
    }
}