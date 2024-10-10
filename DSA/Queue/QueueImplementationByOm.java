

// Problem Statement:
// Implement a simple queue using an array in Java. The queue should support 
// basic operations like enqueue (insertion), dequeue (removal), and display 
// of the current queue contents. Additionally, the queue should have a fixed 
// capacity and handle situations when the queue is full or empty.

import java.util.*;

class Queue {
    int front, rear, capacity; // Define front, rear pointers, and queue capacity
    int[] queue;               // Array to store queue elements

    // Constructor to initialize the queue with a given capacity
    Queue(int c) {
        front = 0;           // Initialize the front pointer to 0
        rear = -1;           // Initialize the rear pointer to -1 (empty queue)
        capacity = c;        // Set the maximum capacity of the queue
        queue = new int[capacity];  // Create the array to hold queue elements
    }

    // Method to add an element to the queue (enqueue operation)
    void enqueue(int data) {
        // Check if the queue is full
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }
        // Add element to the queue and move the rear pointer
        queue[++rear] = data;
    }

    // Method to remove an element from the front of the queue (dequeue operation)
    void dequeue() {
        // Check if the queue is empty
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        // Shift all elements forward by one position
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

        // Decrease the rear pointer as an element has been removed
        rear--;
    }

    // Method to display the elements of the queue
    void display() {
        // Check if the queue is empty
        if (front > rear) {
            System.out.println("Queue is Empty");
            return;
        }

        // Display all elements from front to rear
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " <-- ");
        }
        System.out.println();
    }

    // Method to display the front element of the queue
    void front() {
        // Check if the queue is empty
        if (rear == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        Queue q = new Queue(4);  // Initialize a queue with capacity 4

        q.display();  // Display the empty queue

        // Add elements to the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();  // Display the current state of the queue

        // Try to add another element (queue is full)
        q.enqueue(60);

        q.display();  // Display the state of the queue after the failed insertion

        // Remove two elements from the front of the queue
        q.dequeue();
        q.dequeue();

        System.out.println("After two node deletions");

        q.display();  // Display the queue after deletions

        // Add one more element
        System.out.println("After one insertion");
        q.enqueue(60);

        q.display();  // Display the updated queue

        q.front();  // Display the front element of the queue
    }
}
