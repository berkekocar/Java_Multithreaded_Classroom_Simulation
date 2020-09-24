import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Classroom
{
    volatile boolean isFull;
    volatile boolean classInProgress;
    Queue<Student> room;
    int maxCapacity;
    int studentCount;
    public Boolean[] seats;
    public String name = "";
    ReentrantLock[] locks;
    Lecturer lecturer;
    private boolean status;

    public Classroom(String name, int capacity) {
    isFull = false;
    classInProgress = false;
    studentCount = 0;
    seats = new Boolean[capacity];
    this.name = name;
    locks = new ReentrantLock[capacity];
    status = false;
    for (Boolean seat : seats) {
        seat = true;
    }
}
    public boolean invokeEnter(String name){
        return false;
    }
    public boolean sitDown(String name, int seat){
        locks[seat].lock();
        if (seats[seat]){
            seats[seat] = false;
            locks[seat].unlock();
            return true;

        }
        locks[seat].unlock();
        return false;
    }
    public boolean leave(String name, int seat){
        locks[seat].lock();
        if (!seats[seat]){
            seats[seat] = true;
            locks[seat].unlock();
            return true;
        }
        locks[seat].unlock();
        return false;
    }
    public boolean startLecture(boolean status) {
        this.status = status;
        if (lecturer.classroom.isFull) {
            return status;

        }
        return false;
    }

}