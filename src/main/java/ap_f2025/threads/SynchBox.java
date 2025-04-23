package ap_f2025.threads;

public class SynchBox implements Output, Input
{
    private String item;

    public SynchBox()
    {
        item = null;
    }

    public synchronized void put(String str) throws InterruptedException
    {
        while (item != null)
        {
            wait();
        }
        //We can be sure that item is null here
        item = str;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException
    {
        while (item == null)
        {
            wait();
        }
        //We can be sure that item is not null here
        String str = item;
        item = null;
        notifyAll();
        return str;
    }

}
