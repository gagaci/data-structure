#include <iostream>
using namespace std;

struct Node {
    int data;            // Stores the element
    struct Node* next;   // Pointer to the next node
};

void traverse(Node* head) {
    Node* temp = head;

    while(temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
}

bool search(Node* head, int key) {
    Node* temp = head;

    while(temp != NULL) {
        if(temp->data == key) {
            return true;
        }
        temp = temp->next;
    }
    return false;
}

void insertBegin(Node*& head, int value) {
    Node* newNode = new Node();
    newNode->next = head;
    newNode->data = value;
    head = newNode;
}

void insertEnd(Node*& head, int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = NULL;
    if(head == NULL) {
        head = newNode;
        return;
    }
    Node* temp = head;
    while(temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
}

void insertAtPosition(Node*& head, int value, int pos) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = NULL;
    if(pos == 1) {          // If inserting at beginning
        newNode->next = head;
        head = newNode;
        return;
    }
    Node* temp = head;
    for(int i = 1; i < pos - 1 && temp != NULL; i++) {   // Traverse to (pos - 1)th node
        temp = temp->next;
    }
    if(temp == NULL) {      // If position is invalid
        cout << "Invalid Position";
        return;
    }
    newNode->next = temp->next;
    temp->next = newNode;
}

int main() {
    Node* head = new Node{1, new Node{2, new Node{3, NULL}}};

    cout << "Initial list: ";
    traverse(head);
    cout << "\n";

    bool result = search(head, 2);
    cout << "search(2) -> " << (result ? "found" : "not found") << "\n";

    insertEnd(head, 5);
    cout << "After insertEnd(5): ";
    traverse(head);
    cout << "\n";

    insertBegin(head, 4);
    cout << "After insertBegin(4): ";
    traverse(head);
    cout << "\n";

    insertAtPosition(head, 3, 2);
    cout << "After insertAtPosition(3, 2): ";
    traverse(head);
    cout << "\n";

    return 0;
}
