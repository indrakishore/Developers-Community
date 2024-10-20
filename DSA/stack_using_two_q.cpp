#include <iostream>
#include <queue>

using namespace std;

class Stack_queue {
private:
    queue<int>q1;
    queue<int>q2;

public:
    // Push operation
    void push(int x) {
        // Push element into q2
        q2.push(x);

        // Transfer all elements from q1 to q2
        while (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }

        // Swap q1 and q2
        swap(q1, q2);
    }

    // Pop operation
    void pop() {
        if (q1.empty()) {
            cout << "Stack is empty" << endl;
            return;
        }
        q1.pop();
    }

    // Top operation
    int top() {
        if (q1.empty()) {
            cout << "Stack is empty" << endl;
            return -1;
        }
        return q1.front(); 
    }

    // Check if the stack is empty
    bool isEmpty() {
        return q1.empty();
    }
};

int main() {
    Stack_queue s;
    s.push(1);
    s.push(2);
    s.push(3);

    cout << "Top element: " << s.top() << endl; // Should print 3
    s.pop();

    cout << "Top element after pop: " << s.top() << endl;
}
