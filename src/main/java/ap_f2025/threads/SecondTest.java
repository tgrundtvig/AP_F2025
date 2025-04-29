package ap_f2025.threads;

public class SecondTest
{
    public static void main(String[] args)
    {
        SynchBuffer buffer = new SynchBuffer(4);
        Producer producer1 = new Producer("Producer1", buffer);
        Producer producer2 = new Producer("Producer2", buffer);
        Consumer consumer = new Consumer("Consumer", buffer);
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
