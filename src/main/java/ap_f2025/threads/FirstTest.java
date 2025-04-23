package ap_f2025.threads;

public class FirstTest
{
    public static void main(String[] args)
    {
        SynchBox box = new SynchBox();
        Producer producer1 = new Producer("Producer1", box);
        Producer producer2 = new Producer("Producer2", box);
        Consumer consumer = new Consumer("Consumer", box);
        producer1.start();
        producer2.start();
        consumer.start();
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            // Handle the exception
            System.out.println("Main thread interrupted!");
        }
        producer1.stop();
        producer2.stop();
        consumer.stop();
        System.out.println("Main thread stopped!");
    }
}
