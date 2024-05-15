package packageone;
import java.util.Queue;

public class ClassOne {    
public static void main(String[] args) {
Queue<String> queue = new java.util.LinkedList<>();
 queue.offer("Oklahoma");
 queue.offer("Indiana");
 queue.offer("Georgia");
 queue.offer("Texas");

 while (queue.size() > 3)
 System.out.println(queue.remove() + " Hello");
}


 }
 



