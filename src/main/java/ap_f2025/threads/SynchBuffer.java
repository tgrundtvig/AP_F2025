package ap_f2025.threads;

public class SynchBuffer implements Output, Input, BufferStatus
{
    private String[] items;
    private int size;
    private int head;

    public SynchBuffer(int n)
    {
        items = new String[n];
        size = 0;
        head = 0;
    }

    public synchronized void put(String str) throws InterruptedException
    {
        while (size == items.length)
        {
            wait();
        }
        //We can be sure that size < items.length here
        int tail = (head + size) % items.length;
        items[tail] = str;
        ++size;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException
    {
        while (size == 0)
        {
            wait();
        }
        //We can be sure that size > 0 here
        String str = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        --size;
        notifyAll();
        return str;
    }

    public synchronized boolean isEmpty()
    {
        return size == 0;
    }

    public synchronized boolean isFull()
    {
        return size == items.length;
    }

}