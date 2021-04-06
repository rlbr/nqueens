import java.util.Scanner;

public class A6_P8_IntQueue_LASTNAME_FIRSTNAME
{
   // instance variables here


 
  public A6_P8_IntQueue_LASTNAME_FIRSTNAME()
  // Constructor
  {
   


 
  }
  

  public void enqueue(int element)
  // Adds element to the rear of this queue.
  { 



  }     


  public int dequeue()
  // Removes front element from this queue and returns it.
  {



  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              



  }
  
  
  
  
  // main, just for testing purposes
  public static void main(String [] args)  {
      Scanner kbd = new Scanner(System.in);
      
      A6_P8_IntQueue_LASTNAME_FIRSTNAME q = new A6_P8_IntQueue_LASTNAME_FIRSTNAME();
      int element, choice = 1;
      
      do {

         System.out.println("Menu:  ");
         System.out.println("(1) ENQUEUE");
         System.out.println("(2) DEQUEUE");
         System.out.println("(3) ISEMPTY");
         System.out.println("(4) EMPTY QUEUE");
         System.out.println("(5) QUIT");
         System.out.print("\nPlease enter your choice:  ");          
         choice = kbd.nextInt();

         
         if (choice == 1)  {
            System.out.print("Enter an integer to enqueue:  ");
            element = kbd.nextInt();
            q.enqueue(element);
            System.out.println();
         }
         
         else if (choice == 2)  {
            if (q.isEmpty())
               System.out.println("Cannoe dequeue because the queue is empty.\n");
            else
               System.out.println("Dequeued:  " + q.dequeue() + "\n");
         }
         
         else if (choice == 3)  
            System.out.println("Queue is empty:  " + q.isEmpty() + "\n");
         
         else if (choice == 4)  {
         
            while (!q.isEmpty()) 
               System.out.println("Dequeued:  "  + q.dequeue());
            
            System.out.println("Queue is now empty.\n");
         }
                  
                  
                    
      }  
      while (choice >= 1 && choice <= 4);       
           
   }  // end main
   
} // end class  


