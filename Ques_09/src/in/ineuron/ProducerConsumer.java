package in.ineuron;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
    private static final int MAX_QUEUE_SIZE = 10;
    private static final int NUM_VALUES_TO_PRODUCE = 20;

    private Queue<Integer> queue = new LinkedList<>();
    private Random random = new Random();

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.start();
    }

    public void start() {
        Thread producerThread = new Thread(() -> {
            produce();
        });

        Thread consumerThread = new Thread(() -> {
            consume();
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void produce() {
        for (int i = 0; i < NUM_VALUES_TO_PRODUCE; i++) {
            while (queue.size() >= MAX_QUEUE_SIZE) {
                try {
                    wait(); // Wait if the queue is full
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int value = random.nextInt(100); // Generate a random number
            queue.add(value);
            System.out.println("Produced: " + value);

            notifyAll(); // Notify consumer thread that a value is produced and available
        }
    }

    private synchronized void consume() {
        int sum = 0;
        for (int i = 0; i < NUM_VALUES_TO_PRODUCE; i++) {
            while (queue.isEmpty()) {
                try {
                    wait(); // Wait if the queue is empty
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int value = queue.poll();
            System.out.println("Consumed: " + value);
            sum += value;

            notifyAll(); // Notify producer thread that a value is consumed and space is available

            try {
                Thread.sleep(1000); // Simulate some processing time for the consumer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of consumed values: " + sum);
    }
}
