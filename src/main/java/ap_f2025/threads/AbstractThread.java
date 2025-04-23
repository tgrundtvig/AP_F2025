package ap_f2025.threads;

public abstract class AbstractThread implements Runnable
{
    private Thread thread;
    private volatile boolean stop;

    public AbstractThread()
    {
        this.stop = false;
        this.thread = null;
    }

    public void start()
    {
        thread = new Thread(this);
        thread.start();
    }

    public void stop()
    {
        stop = true;
        if(thread != null)
        {
            thread.interrupt();
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    @Override
    public void run()
    {
        while(!stop)
        {
            try
            {
                loop();
            }
            catch (InterruptedException e)
            {
            }
        }
        thread = null;
    }

    public abstract void loop() throws InterruptedException;
}
