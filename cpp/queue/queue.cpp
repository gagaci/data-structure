#include <iostream>
using namespace std;

class myQueue {
    int *arr;     // array to store elements
    int capacity; // maximum size of queue
    int count;    // number of elements currently in the queue
public:
    myQueue(int cap) {
        capacity = cap;
        arr = new int[capacity];
        count = 0;
    }

    void enqueue(int x) {
        if (count == capacity) {
            cout << "Queue Overflow" << endl;
            return;
        }
        arr[count++] = x;
    }

    void dequeue() {
        if (count == 0) {
            cout << "Queue Underflow" << endl;
            return;
        }

        for (int i = 1; i < count; i++) {
            arr[i - 1] = arr[i];
        }
        count--;
    }

    int getFront() {
        if (count == 0) {
            cout << "Queue is empty" << endl;
            return -1;
        }
        return arr[0];
    }

    int getRear() {
        if (isEmpty()) {
            cout << "No element in the queue" << endl;
            return -1;
        }
        return arr[count - 1];
    }

    bool isEmpty() {
        return count == 0;
    }

    bool isFull() {
        return count == capacity;
    }
};

int main() {
    myQueue q(5);

    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);

    int front = q.getFront();
    int rear = q.getRear();

    cout << "front: " << front << endl;
    cout << "rear: " << rear << endl;

    q.dequeue();
    cout << "rear dequeue front: " << q.getFront() << endl;

    q.enqueue(40);
    q.enqueue(40);
    q.enqueue(40);
    q.enqueue(40);

    return 0;
}
