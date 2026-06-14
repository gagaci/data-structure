#include <iostream>
using namespace std;

class myStack {
    int *arr; // array to store elements
    int capacity; // maximum size of stack
    int top; // index of top element
public:
    myStack(int cap) {
        capacity = cap;
        arr = new int[capacity];
        top = -1;
    }

    void push(int x){
        if(top == capacity - 1){
            cout << "Stack Overflow\n";
            return;
        }

        arr[++top] = x;
    }

    int pop(){
        if (top == -1){
            cout << "Stack Underflow\n";
            return -1;
        }
        return arr[top--];
    }

    int peek(){
        if (top == -1){
            cout << "Stack Underflow\n";
            return -1;
        }
        return arr[top];
    }

    bool isEmpty(){
        return top == -1;
    }
};


int main(){
    myStack s(5);

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

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6); // Stack Overflow

    return 0;
}
