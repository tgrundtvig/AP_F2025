package ap_f2025.threads;

public class Consumer extends AbstractThread
{
    private final String name;
    private final Input input;


    public Consumer(String name, Input input)
    {
        this.name = name;
        this.input = input;
    }

    @Override
    public void loop() throws InterruptedException
    {
        System.out.println(name + " getting item.");
        String str = input.get();
        System.out.println(name + " got item: " + str);
        Thread.sleep(1000 + (int)(Math.random() * 2000));
    }
}
