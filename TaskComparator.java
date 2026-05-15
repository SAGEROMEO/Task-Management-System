import java.util.Comparator;

public class TaskComparator implements Comparator<Task>
{
    //sort by priority
    @Override
    public int compare(Task T1, Task T2) {
        return T1.getPriority() - T2.getPriority();
    }



}
