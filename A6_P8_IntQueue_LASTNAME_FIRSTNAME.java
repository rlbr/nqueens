import java.util.Scanner;

public class A6_P8_IntQueue_LASTNAME_FIRSTNAME {
    // Node class for cicularly linked list
    private class IntNode {
        private int data;
        private IntNode next;

        IntNode(int data) {
            this.data = data;
        }

        int get_data() {
            return this.data;
        }

        IntNode get_next() {
            return this.next;
        }

        void set_next(IntNode next) {
            this.next = next;
        }
    }

    // instance variables here

    IntNode last;

    public A6_P8_IntQueue_LASTNAME_FIRSTNAME()
    // Constructor
    {
        this.last = null;
    }

    public void enqueue(int element)
    // Adds element to the rear of this queue.
    {
        IntNode new_node = new IntNode(element);
        if (this.last == null) {
            this.last = new_node;
            new_node.set_next(new_node);
        }
        else {
            IntNode first = last.get_next();
            new_node.set_next(first);
            this.last.set_next(new_node);
            this.last = new_node;
        }
    }

    public int dequeue()
    // Removes front element from this queue and returns it.
    {
        if (this.last.get_next() == this.last) {
            int value = this.last.get_data();
            this.last = null;
            return value;
        }
        IntNode first = this.last.get_next();
        int value = first.get_data();
        this.last.set_next(first.get_next());
        return value;
    }

    public boolean isEmpty()
    // Returns true if this queue is empty; otherwise, returns false.
    {
        return this.last == null;
    }

    // main, just for testing purposes
    public static void main(String[] args) {
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

            if (choice == 1) {
                System.out.print("Enter an integer to enqueue:  ");
                element = kbd.nextInt();
                q.enqueue(element);
                System.out.println();
            }

            else if (choice == 2) {
                if (q.isEmpty())
                    System.out.println("Cannoe dequeue because the queue is empty.\n");
                else
                    System.out.println("Dequeued:  " + q.dequeue() + "\n");
            }

            else if (choice == 3)
                System.out.println("Queue is empty:  " + q.isEmpty() + "\n");

            else if (choice == 4) {

                while (!q.isEmpty())
                    System.out.println("Dequeued:  " + q.dequeue());

                System.out.println("Queue is now empty.\n");
            }

        } while (choice >= 1 && choice <= 4);

    }  // end main

}
// end class
