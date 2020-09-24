import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Monitor {
    private volatile boolean finish = true;
    int nThreads = Runtime.getRuntime().availableProcessors();
    int seatsS,seatsV;
    Classroom classroom;
    ExecutorService executor = Executors.newFixedThreadPool(nThreads);
    boolean session;

    public Monitor(int nSeats){
        int v = (int)(Math.random()*5);
        int s = (int)(Math.random()*60);
        session = false;
    }
    public void run(){
        int i = 0;

        while (finish){
            int seatV = (int)(Math.random()*5);
            int seatS = (int)(Math.random()*10);
            String nameV = "Visitor\t" + i;
            String nameS = "Student\t" + i;
            i++;
            String nameL = "Lecturer\t";
            try {
                //Runnable visitor = new Visitor(nameV,classroom,seatV);
                // Runnable student = new Student(nameS,classroom,seatS);
                //Runnable lecturer = new Lecturer(nameL,classroom);
                //executor.execute(visitor);
                //executor.execute(student);
                //executor.execute(lecturer);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void terminate(){
        finish = false;
        try {
            executor.shutdownNow();
            if (executor.isTerminated()){
                //Class is done...
            }
            else{
                //Class still in progress...
            }
        }catch (Exception e){}

    }


}
