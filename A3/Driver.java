import java.util.Random;

/**
 * Created by Ling Tan on 2017-03-24.
 */
public class Driver {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------Generating 20 cases for testing-----------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println("---------Case " + (i + 1)+ ":-----------------------------------------------------------------------------------------------------------------");
            PriorityQueue pq = new PriorityQueue();
            Random r = new Random();
            int number = 1 + r.nextInt(100);
            for (int j = 0; j < number; j++) {
                int key = r.nextInt(1000);
                String value = generateString();
                pq.insert(new PriorityQueue.Entry(key, value));
            }
            System.out.println(pq.toString());
            System.out.println("---------Case " + (i + 1) + ", toggle():-------------------------------------------------------------------------------------------------------");
            pq.toggle();
            System.out.println(pq.toString());
            System.out.println("---------Case " + (i + 1) + ", insert():-------------------------------------------------------------------------------------------------------");
            int key = r.nextInt(1000);
            String value = generateString();
            pq.insert(new PriorityQueue.Entry(key, value));
            System.out.println(pq.toString());
            System.out.println("---------Case " + (i + 1) + ", remove():-------------------------------------------------------------------------------------------------------");
            pq.remove();
            System.out.println(pq.toString());
            System.out.println("---------Case " + (i + 1) + ", top():----------------------------------------------------------------------------------------------------------");
            PriorityQueue.Entry entry = pq.top();
            System.out.println(entry.toString());
            System.out.println("---------Case " + (i + 1) + ", switchToMin():--------------------------------------------------------------------------------------------------");
            pq.switchToMin();
            System.out.println(pq.toString());
            System.out.println("---------Case " + (i + 1) + ", switchToMax():--------------------------------------------------------------------------------------------------");
            pq.switchToMax();
            System.out.println(pq.toString());
            System.out.println("---------Case " + (i + 1) + ", state():--------------------------------------------------------------------------------------------------------");
            System.out.println(pq.state());
            System.out.println("---------Case " + (i + 1) + ", size():---------------------------------------------------------------------------------------------------------");
            System.out.println(pq.size());
            System.out.println("---------Case " + (i + 1) + ", isEmpty():------------------------------------------------------------------------------------------------------");
            System.out.println(pq.isEmpty());
        }
    }

    private static String generateString() {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int number = 1 + r.nextInt(10);
        for (int i = 0; i < number; i++) {
            int key = 33 + r.nextInt(94);
            sb.append((char) key);
        }
        return sb.toString();
    }
}
