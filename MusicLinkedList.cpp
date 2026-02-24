#include <iostream>
using namespace std;

class Node {
public:
string songName;
string artistName;
int duration;
Node* next;
Node(string newSongName,string newArtistName, int newDuration) {
songName = newSongName;
artistName = newArtistName;
duration = newDuration;
next = NULL;
}

Node(){
    
}


void insert(Node* head,string newSongName,string newArtistName, int newDuration){
    Node* newNode = new Node();
}

};