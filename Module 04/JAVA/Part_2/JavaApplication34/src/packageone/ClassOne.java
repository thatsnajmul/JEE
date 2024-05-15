package packageone;

import java.text.DateFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimeZone;

public class ClassOne {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Allan");
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");

        while (queue.size() > 4) {
            System.out.println("Hello, " + queue.remove() + "Your time is" + "TimeZone");
        }

    }

}
