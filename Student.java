import java.util.Random;

public class Student implements Runnable {
    String name;
    Classroom classroom;
    int seat;
    Random random;

    public Student(String name, Classroom classroom, int seat) {
        this.name = name;
        this.classroom = classroom;
        this.seat = seat;
        random = new Random(classroom.studentCount);
    }
    @Override
    public synchronized void run() {
        if (!classroom.sitDown(name, seat)) {
            boolean control = true;
            while (control) {
                seat = (seat++) % (classroom.seats.length);
                if (classroom.sitDown(name, seat)) {
                    control = false;
                }

            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        classroom.leave(name,seat);
    }
    }

