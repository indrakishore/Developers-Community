/*
    This program implements a **doubly linked list** with various operations. 
    A doubly linked list allows traversal in both directions (forward and backward) 
    as each node contains two pointers: `next` (points to the next node) and `prev` 
    (points to the previous node).

    Key Features of the Program:
    1. **Insert at Head**: Adds new elements to the beginning of the list.
    2. **Insert at Tail**: Adds new elements to the end of the list.
    3. **Insert at Position**: Inserts an element at a specific position in the list.
    4. **Delete at Position**: Removes an element from a specified position.
    5. **Display**: Prints all the elements of the list from head to tail.
    6. **Reverse List**: Reverses the order of the elements in the list.
    7. **Concatenate Two Lists**: Joins two doubly linked lists into a single list.

    The program uses a **menu-driven interface** to allow users to interact with 
    the linked list by selecting operations. It also dynamically allocates memory 
    using the `new` operator and ensures proper memory cleanup to prevent memory leaks.
    This is a practical implementation to understand data structures concepts 
    like dynamic memory management and linked lists.
*/

#include <iostream>
using namespace std;

class node {
public:
    int data;
    node* next;
    node* prev;

    node(int d) {
        this->data = d;
        this->next = NULL;
        this->prev = NULL;
    }

    ~node() {
        if (next != NULL) {
            delete next;
            next = NULL;
        }
    }
};

void insertathead(node*& head, node*& tail, int d) {
    if (head == NULL) {
        node* temp = new node(d);
        head = temp;
        tail = temp;
    } else {
        node* temp = new node(d);
        temp->next = head;
        head->prev = temp;
        head = temp;
    }
}

void insertattail(node*& head, node*& tail, int d) {
    if (tail == NULL) {
        node* temp = new node(d);
        head = temp;
        tail = temp;
    } else {
        node* temp = new node(d);
        tail->next = temp;
        temp->prev = tail;
        tail = temp;
    }
}

void insertatposition(int position, node*& head, node*& tail, int d) {
    if (position == 1) {
        insertathead(head, tail, d);
        return;
    }

    node* temp = head;
    int count = 1;

    while (count < position - 1 && temp != NULL) {
        temp = temp->next;
        count++;
    }

    if (temp == NULL || temp->next == NULL) {
        insertattail(head, tail, d);
        return;
    }

    node* nodetoinsert = new node(d);
    nodetoinsert->next = temp->next;
    temp->next->prev = nodetoinsert;
    temp->next = nodetoinsert;
    nodetoinsert->prev = temp;
}

void deleteatposition(node*& head, node*& tail, int position) {
    if (position == 1) {
        node* temp = head;
        head = head->next;
        if (head != NULL) {
            head->prev = NULL;
        } else {
            tail = NULL; // If the list becomes empty
        }
        temp->next = NULL;
        delete temp;
        return;
    }

    node* curr = head;
    int count = 1;

    while (count < position && curr != NULL) {
        curr = curr->next;
        count++;
    }

    if (curr == NULL) {
        cout << "Position out of bounds." << endl;
        return;
    }

    if (curr->next == NULL) {
        tail = curr->prev;
        tail->next = NULL;
    } else {
        curr->prev->next = curr->next;
        curr->next->prev = curr->prev;
    }

    curr->next = NULL;
    curr->prev = NULL;
    delete curr;
}

void display(node* head) {
    node* temp = head;
    while (temp != NULL) {
        cout << temp->data << " -> ";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

// Reverse the linked list
void reverseList(node*& head, node*& tail) {
    node* temp = NULL;
    node* curr = head;

    // Swap next and prev pointers for each node
    while (curr != NULL) {
        temp = curr->prev;
        curr->prev = curr->next;
        curr->next = temp;
        curr = curr->prev;  // Move to the next node
    }

    // Swap head and tail pointers
    if (temp != NULL) {
        temp = temp->prev;
        swap(head, tail);
    }
}

// Concatenate two doubly linked lists
void concatenateLists(node*& head1, node*& tail1, node*& head2, node*& tail2) {
    if (head1 == NULL) {
        head1 = head2;
        tail1 = tail2;
        return;
    }
    if (head2 == NULL) return;

    tail1->next = head2;
    head2->prev = tail1;
    tail1 = tail2;
}

int main() {
    node* head1 = NULL;
    node* tail1 = NULL;
    node* head2 = NULL;
    node* tail2 = NULL;

    int choice, n, value, position;

    while (true) {
        cout << "\nMenu: \n";
        cout << "1. Insert at Head\n";
        cout << "2. Insert at Tail\n";
        cout << "3. Insert at Position\n";
        cout << "4. Delete at Position\n";
        cout << "5. Display List\n";
        cout << "6. Reverse List\n";
        cout << "7. Concatenate Two Lists\n";
        cout << "8. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter the number of values to insert at head: ";
            cin >> n;
            cout << "Enter the values to insert at head: ";
            for (int i = 0; i < n; i++) {
                cin >> value;
                insertathead(head1, tail1, value);
            }
            break;

        case 2:
            cout << "Enter the number of values to insert at tail: ";
            cin >> n;
            cout << "Enter the values to insert at tail: ";
            for (int i = 0; i < n; i++) {
                cin >> value;
                insertattail(head1, tail1, value);
            }
            break;

        case 3:
            cout << "Enter the position and value to insert: ";
            cin >> position >> value;
            insertatposition(position, head1, tail1, value);
            break;

        case 4:
            cout << "Enter the position to delete: ";
            cin >> position;
            deleteatposition(head1, tail1, position);
            break;

        case 5:
            cout << "The linked list is: ";
            display(head1);
            break;

        case 6:
            reverseList(head1, tail1);
            cout << "The list has been reversed." << endl;
            break;

        case 7:
            cout << "Enter values for the second list (enter -1 to stop): ";
            while (true) {
                cin >> value;
                if (value == -1) break;
                insertattail(head2, tail2, value);
            }
            concatenateLists(head1, tail1, head2, tail2);
            cout << "The lists have been concatenated." << endl;
            break;

        case 8:
            cout << "Exiting program." << endl;
            return 0;

        default:
            cout << "Invalid choice. Please try again." << endl;
        }
    }

    return 0;
}
