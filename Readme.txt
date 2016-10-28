A small program desmontrating multi-threading for CS351.
Requirements:
Main thread of program must start up two worker threads. 
Each worker thread must independently walk the Fibonacci sequence (1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...). 
Implement in single file (public class and inner class).
Every 2 seconds the main thread must print:
  Each worker thread¡¯s name,
  Each worker thread¡¯s step number 
  Each worker thread¡¯s three active sequence values (x, y and z). 
The info about x, y and z must be printed form the main thread.