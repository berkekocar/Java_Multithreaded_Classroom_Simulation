import java.util.Random;

public class Visitor extends Thread {
    String name;
    Random random;
    Classroom classroom;
    int seat;
    public Visitor(String threadName, Classroom classroom, int seat){
        super(threadName);
        this.name = name;
        this.classroom = classroom;
        this.seat = seat;
        random = new Random();
    }
    @Override
    public void run() {
        super.run();
        try {
            int rand = random.nextInt(5);
            for (int i = 0; i < rand; i++) {
                Thread.sleep(10);
                if (!classroom.sitDown(name, seat)){
                    boolean control = true;
                    while (control) {
                        seat = (seat++) % (classroom.seats.length);
                        if (classroom.sitDown(name, seat)) {
                            control = false;
                        }
                    }
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
