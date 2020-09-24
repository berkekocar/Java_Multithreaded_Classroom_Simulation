import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args)  throws  InterruptedException{
        Random random = new Random();
        HashMap<Integer, Classroom> classroomList = new HashMap<Integer, Classroom>();
        String[] lecturer = new String[]{"Osama", "Barry", "Faheem", "Alex", "Aqeel", "Waseem"};

        Classroom W201 = new Classroom("W201", 60);
        Classroom W202 = new Classroom("W202", 60);
        Classroom JS101 = new Classroom("JS101", 30);
        Classroom W101 = new Classroom("W101", 20);

        classroomList.put(1,W101);
        classroomList.put(2,W201);
        classroomList.put(3,W202);
        classroomList.put(4,JS101);

        Monitor monitor = new Monitor(classroomList.size());
        monitor.run();

        Scanner input = new Scanner(System.in);
        System.out.println("Please press -1 for terminating the program...");
        System.out.println("==================================================================================\n" +
                "\t\tClassroom Lecturer InSession Students Visitors\n" +
                "==================================================================================");
        while (true){
            int lecIx = random.nextInt(5);
            for (int keys : classroomList.keySet())
            {
                if (lecIx > 2){
                lecIx = lecIx -2;
                System.out.println(classroomList.get(keys).name + "\t" +lecturer[lecIx] + "\t" + monitor.session +"\t" +monitor.seatsS + "\t" + monitor.seatsV);
                lecIx++;
            }else {
                lecIx = 0;
                System.out.println(classroomList.get(keys).name + "\t" +lecturer[lecIx] + "\t" + monitor.session + "\t" + monitor.seatsS + "\t" + monitor.seatsV);
                lecIx++;
            }

            }
            Thread.sleep(2000);

        }

        //monitor.terminate();

    }

    }

