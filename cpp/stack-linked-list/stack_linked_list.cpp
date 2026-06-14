#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

class myStack {
    // pointer to top node
    Node* top;

public:
    myStack() {
        // initially stack is empty
        top = NULL;
    }

    void push(int x) {
        Node* temp = new Node(x);
        temp->next = top;
        top = temp;
    }

    int pop() {
        if (top == NULL) {
            cout << "Stack Underflow" << endl;
            return -1;
        }
        Node* temp = top;
        top = temp->next;
        int x = temp->data;
        delete temp;
        return x;
    }

    int peek() {
        if (top == NULL) {
            cout << "Stack Underflow" << endl;
            return -1;
        }
        return top->data;
    }

    int isEmpty() {
        return top == NULL;
    }
};

int main() {
    myStack s;

    s.push(10);
    s.push(20);
    s.push(30);

    cout << "Peek: " << s.peek() << endl;   // 30

    cout << "Pop: " << s.pop() << endl;     // 30
    cout << "Pop: " << s.pop() << endl;     // 20

    cout << "Peek: " << s.peek() << endl;   // 10

    cout << "Is Empty: " << s.isEmpty() << endl; // 0

    s.pop();
    cout << "Is Empty: " << s.isEmpty() << endl; // 1

    s.pop(); // Stack Underflow

    return 0;
}
