package ap_f2025.threads;

public class ThirdTest
{
    public static void main(String[] args)
    {
        SynchBuffer buffer = new SynchBuffer(4);
        Producer producer1 = new Producer("Producer1", buffer);
        Producer producer2 = new Producer("Producer2", buffer);
        DynamicConsumers dcs = new DynamicConsumers(buffer, buffer);
        producer1.start();
        producer2.start();
        try
        {
            Thread.sleep(30000);
        }
        catch (InterruptedException e)
        {
            // Handle the exception
            System.out.println("Main thread interrupted!");
        }
        producer1.stop();
        producer2.stop();
        System.out.println("Main thread stopped!");
    }
}
