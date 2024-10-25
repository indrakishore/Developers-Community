// Define the Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define the LinkedList class
public class ReverseLL {
    Node head = null;
    Node tail = null;

    // Method to reverse the linked list using recursion
    public void reverse(Node node) {
        if (node.next == null) {
            head = node;
            return;
        }
        reverse(node.next);
        node.next.next = node;
        node.next = null;
    }

    // Method to add elements to the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.print("Null");
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original list:");
        list.printList();

        list.reverse(list.head);

        System.out.println("Reversed list:");
        list.printList();
    }
}


