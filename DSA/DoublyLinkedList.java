class Node {
    int data;
    Node next;
    Node prev;

    // Node constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Node head;

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current; // Link back to previous node
        }
    }

    // Method to display the list from head to tail
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the list from tail to head
    public void displayBackward() {
        Node current = head;
        if (current == null) return;

        // Go to the last node
        while (current.next != null) {
            current = current.next;
        }
        // Traverse backward
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Method to delete a node by value
    public void delete(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                if (current.prev != null) {
                    current.prev.next = current.next; // Bypass the node
                } else {
                    head = current.next; // Move head if necessary
                }
                if (current.next != null) {
                    current.next.prev = current.prev; // Bypass the node
                }
                return; // Node deleted
            }
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Insert nodes
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);

        System.out.println("Doubly Linked List in forward direction:");
        dll.displayForward(); // Output: 10 20 30 40

        System.out.println("Doubly Linked List in backward direction:");
        dll.displayBackward(); // Output: 40 30 20 10

        // Delete a node
        dll.delete(20);
        System.out.println("After deleting 20:");
        dll.displayForward(); // Output: 10 30 40
    }
}
