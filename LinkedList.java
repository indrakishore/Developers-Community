// Node class representing each node in the linked list
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class implementing linked list functionality
public class LinkedList<T> {
    private Node<T> head; // Head of the linked list
    private int size;     // Size of the linked list

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Method to insert a new element at the end of the list
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode; // List is empty
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Link new node at the end
        }
        size++;
        System.out.println(data + " inserted into the list.");
    }

    // Method to delete an element from the list
    public void delete(T data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + data);
            return;
        }

        // If the head needs to be removed
        if (head.data.equals(data)) {
            head = head.next; // Update head
            size--;
            System.out.println(data + " deleted from the list.");
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        // Traverse the list to find the node to delete
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }

        // Node not found
        if (current == null) {
            System.out.println(data + " not found in the list.");
            return;
        }

        previous.next = current.next; // Bypass the current node
        size--;
        System.out.println(data + " deleted from the list.");
    }

    // Method to search for an element in the list
    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Element found
            }
            current = current.next;
        }
        return false; // Element not found
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node<T> current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to get the size of the linked list
    public int size() {
        return size;
    }

    // Main method to test the linked list implementation
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Inserting elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        // Display the linked list
        list.display();

        // Searching for an element
        System.out.println("Searching for 20: " + list.search(20));
        System.out.println("Searching for 50: " + list.search(50));

        // Deleting elements
        list.delete(20);
        list.delete(50);

        // Display the linked list after deletion
        list.display();

        // Check the size of the linked list
        System.out.println("Size of the linked list: " + list.size());
    }
}
