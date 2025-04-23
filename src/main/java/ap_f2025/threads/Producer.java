package ap_f2025.threads;

public class Producer extends AbstractThread
{
    private final String name;
    private final Output output;
    private int num = 0;

    public Producer(String name, Output output)
    {
        this.name = name;
        this.output = output;
        this.num = 0;
    }

    @Override
    public void loop() throws InterruptedException
    {
        Thread.sleep(1000 + (int)(Math.random() * 2000));
        ++num;
        String str = name + ":" + num;
        System.out.println(name + " produced: " + str);
        output.put(str);
    }
}
