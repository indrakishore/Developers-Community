/*This Java program implements a basic queue data structure using a linked list. It provides methods for common queue operations:

Enqueue: adds an element to the end of the queue
Dequeue: removes an element from the front of the queue
Peek: returns the front element without removing it
isEmpty: checks if the queue is empty
printQueue: prints the elements of the queue
The program demonstrates the usage of these operations and provides a clear example of how to implement a queue in Java.*/

// Node class representing each element in the queue
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class with enqueue, dequeue, and peek operations
class Queue {
    Node front;
    Node rear;

    // Constructor to initialize the queue
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue operation to remove an element from the queue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Peek operation to view the front element of the queue
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    // isEmpty operation to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // printQueue operation to print the elements of the queue
    public void printQueue() {
        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

// Main class to test the Queue implementation
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Queue elements: ");
        queue.printQueue();

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Queue elements after dequeue: ");
        queue.printQueue();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
