package Primary;

public class FibonacciWalk
{
  private class WorkerThread extends Thread
  {
    private final String NAME; //Name of thread 
    private long step = 0; //Steps since start
    private long z; // fib(step) 
    private long y = 1; // fib(step-1) 
    private long x = 1; // fib(step-2)

    public WorkerThread(String NAME)
    {
      this.NAME=NAME;
    }
    
    public void run()
    {
      for(;;)
      {
        z=x+y;
        step++;
        x=y;
        y=z;
      }
    }
    
    
    
  }
   
  
  
  
  

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
