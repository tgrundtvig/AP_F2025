package ap_f2025.threads;

public class DynamicConsumers
{
    private int cunsumerCount;
    private int nextConsumerID;
    private final Input input;
    private final BufferStatus bufferStatus;

    public DynamicConsumers(Input input, BufferStatus bufferStatus)
    {
        this.input = input;
        this.bufferStatus = bufferStatus;
        this.cunsumerCount = 1;
        this.nextConsumerID = 1;
        Consumer c = new Consumer("Consumer_" + nextConsumerID);
        ++nextConsumerID;
        System.out.println("Creating new consumer: " + c.name);
        c.start();
    }

    private class Consumer extends AbstractThread
    {
        private final String name;

        private Consumer(String name)
        {
            this.name = name;
        }

        @Override
        public void loop() throws InterruptedException
        {
            if(bufferStatus.isFull())
            {
                Consumer c = new Consumer("Consumer_" + nextConsumerID);
                System.out.println("Creating new consumer: " + c.name);
                ++nextConsumerID;
                c.start();
            }
            else if(bufferStatus.isEmpty() && cunsumerCount > 1)
            {
                System.out.println(name + " stopping.");
                cunsumerCount--;
                stop();
                return;
            }
            System.out.println(name + " getting item.");
            String str = input.get();
            System.out.println(name + " got item: " + str);
            Thread.sleep(2000 + (int)(Math.random() * 3000));
        }
    }
}
