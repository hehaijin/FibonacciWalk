package Primary;

public class FibonacciWalk
{
  private static class WorkerThread extends Thread
  {
    private final String NAME; // Name of thread
    private long step = 0; // Steps since start
    private long z; // fib(step)
    private long y = 1; // fib(step-1)
    private long x = 1; // fib(step-2)
    private boolean flag=true;

    public WorkerThread(String NAME)
    {
      this.NAME = NAME;
      z=x+y;
    }

    public void run()
    {
      for (;flag;)
      {
        synchronized(this)
        {
        
   
        if (z == 7540113804746346429L)
        {
          x = 1;
          y = 1;
        } 
        else
        {
          x = y;
          y = z;
        }
        
        z=x+y;
        step++;
        
        }
        
      }
    }

   synchronized public void reportStatus()
    {
      System.out.println("the thread reporting is "+ NAME);
      System.out.println("the step number is "+step);
      System.out.println("the active numbers are "+x+" "+ y+" "+z);
      System.out.println();
    }
   
   public void end()
   {
     flag=false;
   }
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    
    WorkerThread th1=new WorkerThread("worker thread 1");
    WorkerThread th2=new WorkerThread("worker thread 2");
    th1.start();
    th2.start();
    for(int i=0;i<4;i++)
    {
      th1.reportStatus();
      th2.reportStatus();
      try{
      Thread.sleep(2000);
      }catch(Exception e)
      {
        
      }
    }
    th1.end();
    th2.end();

  }

}
