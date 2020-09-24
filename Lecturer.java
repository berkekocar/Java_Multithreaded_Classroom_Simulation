import java.util.Random;

public class Lecturer implements Runnable{
    String name;
    Classroom classroom;
    Random random;
    public String[] lecturer;

    public Lecturer(String name, Classroom classroom) {
        this.name = name;
        this.classroom = classroom;
        random = new Random();

    }
    @Override
    public synchronized void run() {
        int a = random.nextInt(5);
        System.out.println(lecturer[a]);
        try {
            for (int i = 0; i < lecturer.length; i++){
                boolean control = true;
                while (control){
                    control = false;
                }

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(500);
        }catch (Exception e){}
        classroom.leave(name,lecturer.length-1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
