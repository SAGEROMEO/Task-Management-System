import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.*;


public non-sealed class TaskManager<T extends Task> extends ScheduledTask implements TaskFilter{


    private Map<Integer, T> tasks = new HashMap<>();

    // Set allows unique users only
    private Set<User> users = new HashSet<>();

    public TaskManager(int id, String description, String dueDate, int priority) {
        super(id, description, dueDate, priority);
    }

    public TaskManager() {
        super();
    }

    // Add user
    public void addUser(User user) {
        users.add(user);
    }

    // Add task
    public void addTask(T task) {
        tasks.put(task.getId(), task);
    }

    // Assign task
    public void assignTask(int taskId, int userId) {
        T task = tasks.get(taskId);

        Optional<User> userOpt = users.stream()
                .filter(u -> u.getId() == userId)
                .findFirst();

        if (task != null && userOpt.isPresent()) {
            task.assignUser(userOpt.get());
        }
    }

    // Display all tasks
    public void displayTasks()
    {
        tasks.values().forEach(task ->
        {
            task.displayDetails();

            if (task.getAssignedUser() != null)
            {
                System.out.println("Assigned to: " + task.getAssignedUser().getName());

            }
        });
        System.out.println("\n-------------------");
    }


    public List<T> getTasksSortedByPriority() {
        List<T> taskList = new ArrayList<>(tasks.values());

        taskList.sort((t1, t2) -> {
            int p1 = (t1 instanceof Prioritizable p1Obj) ? p1Obj.getPriorityLevel() : Integer.MAX_VALUE;
            int p2 = (t2 instanceof Prioritizable p2Obj) ? p2Obj.getPriorityLevel() : Integer.MAX_VALUE;

            return Integer.compare(p1, p2); // lower number = higher priority
        });

        return taskList;
    }

    //store sorted tasks in map then display
    private Map<Integer, T> Sortedtasks = new LinkedHashMap<>();

    public void displayTasksByPriority()
    {
        List<T> sorted = getTasksSortedByPriority();

        tasks.values().forEach(task -> Sortedtasks.put(task.getId(), task)); //adding sorted tasks from list to Map

        Sortedtasks.forEach((taskId, task) -> System.out.println(task)); //printing sorted tasks from Map


        System.out.println("\n-------------------");
    }

    @Override
    public boolean filter(Task task) {

        List<T> sorted = getTasksSortedByPriority();

        Predicate<Task> isScheduled = p -> p.getPriority() < 5 ;


        Map<Integer, List<Task>> groupedData =  sorted.stream()
                .collect(Collectors.groupingBy(Task::getPriority));
        System.out.println(groupedData);


        return true;
    }

    public void FilterTasksByPriorityLevel(int priority)
    {
        List<T> sorted = getTasksSortedByPriority();
        //Optional<Integer> priorityLevel = sorted;
        System.out.println("\nTasks filtered by priority level.");

        sorted.stream()
                .filter(p -> p.getPriority() > priority)
                .forEach(System.out::println);


        System.out.println("\n-------------------");
    }
}
