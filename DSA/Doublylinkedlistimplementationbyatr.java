class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int val) {
            data = val;
            prev = null;
            next = null;
        }
    }
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    // Function to insert a node at the front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Function to insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Function to delete a node by value
    public void deleteNode(int value) {
        if (head == null) return; // Empty list

        Node temp = head;

        // Traverse to find the node to delete
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) return; // Node not found
        if (temp == head) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            // Node is in the middle or end
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            temp.prev.next = temp.next;
        }
    }

    // Function to reverse the doubly linked list
    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            // Swap prev and next for each node
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Function to concatenate another doubly linked list to this list
    public void concatenate(DoublyLinkedList otherList) {
        if (head == null) {
            head = otherList.head;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = otherList.head;
        if (otherList.head != null) {
            otherList.head.prev = temp;
        }

        otherList.head = null; // Clear the other list
    }

    // Function to print the list in forward order
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to print the list in reverse order
    public void printReverse() {
        Node temp = head;
        if (temp == null) return;

        // Go to the end of the list
        while (temp.next != null) {
            temp = temp.next;
        }

        // Print the list in reverse order
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();

        // Insertion
        list1.insertAtEnd(10);
        list1.insertAtEnd(20);
        list1.insertAtFront(5);
        list1.insertAtEnd(30);
        
        System.out.println("List after insertions: ");
        list1.printList();

        // Deletion
        list1.deleteNode(20);
        System.out.println("List after deleting 20: ");
        list1.printList();

        // Reverse the list
        list1.reverse();
        System.out.println("List after reversal: ");
        list1.printList();

        // Concatenation
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertAtEnd(100);
        list2.insertAtEnd(200);
        System.out.println("Second list: ");
        list2.printList();

        list1.concatenate(list2);
        System.out.println("List after concatenation: ");
        list1.printList();
    }
}
