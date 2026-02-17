#include <iostream>
using namespace std;


struct Node {
	int data; 			// Stores the element
	struct Node* next;     // Pointer to the next node
  };

  void traverse(Node* head){
    Node* temp = head;

    while(temp != NULL){
        cout << temp->data << " ";
        temp = temp->next;
    }
  }

  bool search(Node* head, int key){
    Node* temp = head;

    while(temp!=NULL){
        if(temp->data == key){
            return true;
        }
        temp = temp->next;
    }
    return false;
  }

  void insertBegin(Node* head, int value){
    Node* newNode = new Node();
    newNode->next = head;
    newNode->data = value;
    head = newNode;
    Node* temp = head;

     while(temp != NULL){
        cout << temp->data << " ";
        temp = temp->next;
    }
  }

  void insertEnd(Node*& head, int value){
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = NULL;
    if(head == NULL){
        head = newNode;
        return;
    }
    Node* temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp->next = newNode;

    temp = head;  // Reset to start of list
    while(temp != NULL){
        cout << temp->data << " ";
        temp = temp->next;
    }
  }

  void insertAtPosition(Node*& head, int value, int pos) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = NULL;
        if(pos == 1) {		// If inserting at beginning
        newNode->next = head;
        head = newNode;
        return;
    }
    Node* temp = head;
    for(int i = 1; i < pos - 1 && temp != NULL; i++) {	// Traverse to (pos - 1)th node
        temp = temp->next;
    }
    if(temp == NULL) {				// If position is invalid
        cout << "Invalid Position";
        return;
    }
    newNode->next = temp->next;
    temp->next = newNode;
}

int main() {

Node* head = new Node{1, new Node{2, new Node{3, NULL}}};

traverse(head);

bool result = search(head, 2);

cout<<"\n";

cout<<result;

cout<<"\n";

insertEnd(head, 5);

cout<<"\n";

insertBegin(head, 4);

cout<<"\n";

insertAtPosition(head, 3, 2);

cout<<"\n";



 return 0;
}