import java.util.*;

class Queue {
    int front, rear, capacity;
    int[] queue;

    
    Queue(int c) {
        front = 0;
        rear = -1;
        capacity = c;
        queue = new int[capacity];
    }

  
    void enqueue(int data) {
        // Check if the queue is full
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }

       
        queue[++rear] = data;
    }

    void dequeue() {
     
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

      
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

       
        rear--;
    }

    
    void display() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " <-- ");
        }
        System.out.println();
    }

  
    void front() {
        if (rear == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }

    public static void main(String[] args) {
  
        Queue q = new Queue(4);

      
        q.display();

        
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

       
        q.display();

       
        q.enqueue(60);

        
        q.display();

     
        q.dequeue();
        q.dequeue();

        System.out.println("After two node deletions");

        
        q.display();

        System.out.println("After one insertion");
        q.enqueue(60);

        
        q.display();

        q.front();
    }
}
