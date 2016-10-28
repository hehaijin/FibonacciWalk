package Primary;

/**
 * 
 * @author Haijin He
 *
 */
public class FibonacciWalk
{
  private static class WorkerThread extends Thread
  {
    private final String NAME; // Name of thread
    private long step = 0; // Steps since start
    private long z; // fib(step)
    private long y = 1; // fib(step-1)
    private long x = 1; // fib(step-2)
    private boolean flag = true;// controls the running of the thread.

    public WorkerThread(String NAME)
    {
      this.NAME = NAME;
      z = x + y;
      step++;
    }

    public void run()
    {
      for (; flag;)
      {
        synchronized (this)
        {

          if (z == 7540113804746346429L)
          {
            x = 1;
            y = 1;
          } else
          {
            x = y;
            y = z;
          }

          z = x + y;
          step++;

        }

      }
      System.out.println(NAME + " is signning out!");
    }

    synchronized public void reportStatus()
    {
      System.out.print(NAME);
      System.out.print(" step:" + step);
      System.out.print(" the active numbers are: " + x + " " + y + " " + z);
      System.out.println();
    }

    public void end()
    {
      flag = false;
    }
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

    WorkerThread th1 = new WorkerThread("worker thread 1");
    WorkerThread th2 = new WorkerThread("worker thread 2");
    th1.start();
    th2.start();
    for (int i = 0; i < 10; i++)
    {
      th1.reportStatus();
      th2.reportStatus();
      try
      {
        Thread.sleep(2000);
      } catch (Exception e)
      {
        System.out.println("something is wrong");

      }
    }
    System.out.println("Now ending the worker threads");
    th1.end();
    th2.end();

    
    while (th1.isAlive() || th2.isAlive())
    {
      System.out.println("Worker threads are not completely stopped!");
    }

    System.out.println("Program Exit!");
    System.exit(0);

  }

}
