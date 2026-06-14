#include <iostream>
using namespace std;

class Node {
public:
    string songName;
    string artistName;
    int duration; // in minutes
    Node* next;

    Node(string newSongName, string newArtistName, int newDuration) {
        songName = newSongName;
        artistName = newArtistName;
        duration = newDuration;
        next = NULL;
    }
};

class Playlist {
public:
    Node* head;

    Playlist() {
        head = NULL;
    }

    void insertNewSong(Node* newNode) {
        newNode->next = head;
        head = newNode;
    }

    string deleteSongByName(string songName) {
        string song = "";
        if (head == NULL) {
            cout << "List is empty" << endl;
            return song;
        } else if (head->songName == songName) {
            song = head->songName;
            head = head->next;
            return song;
        }

        Node* curr = head;
        Node* prev = NULL;

        while (curr != NULL) {
            if (curr->songName == songName) {
                song = curr->songName;
                prev->next = curr->next;
                break;
            }
            prev = curr;
            curr = curr->next;
        }

        return song;
    }

    void playNextSong(Node* node) {
        if (node == NULL) {
            cout << "PlayList is empty" << endl;
        } else {
            cout << "\n" << endl;
            cout << "Song name " << node->next->songName << endl;
            cout << "artist name " << node->next->artistName << endl;
            cout << "duration " << node->next->duration << endl;
        }
    }

    void searchSongByName(string name) {
        Node* curr = head;
        bool isFound = false;
        while (curr != NULL) {
            if (curr->songName == name) {
                cout << "\n" << endl;
                cout << "Song was found" << endl;
                cout << "Song name " << curr->songName << endl;
                cout << "artist name " << curr->artistName << endl;
                cout << "duration " << curr->duration << endl;
                isFound = true;
            }
            curr = curr->next;
        }

        if (!isFound) {
            cout << "Song doesn't exist" << endl;
        }
    }

    int countTotalNum() {
        int count = 0;
        Node* curr = head;

        while (curr != NULL) {
            count++;
            curr = curr->next;
        }
        return count;
    }

    void displayPlaylist() {
        Node* temp = head;
        while (temp != NULL) {
            cout << "\n" << endl;
            cout << "Song name " << temp->songName << endl;
            cout << "artist name " << temp->artistName << endl;
            cout << "duration " << temp->duration << endl;

            temp = temp->next;
        }
    }
};

int main() {
    Playlist list;
    Node* node1 = new Node("X", "XX", 1);
    Node* node2 = new Node("Y", "YY", 1);
    Node* node3 = new Node("Z", "ZZ", 1);
    Node* node4 = new Node("D", "DD", 1);
    list.insertNewSong(node1);
    list.insertNewSong(node2);
    list.insertNewSong(node3);
    list.insertNewSong(node4);
    string deleteSongName = list.deleteSongByName("Y");
    list.displayPlaylist();

    cout << "\n" << endl;
    cout << "Deleted song name " << deleteSongName << endl;

    cout << "\n" << endl;
    cout << "Displaying next song of : " << node4->songName << endl;
    list.playNextSong(node4);
    list.searchSongByName("X");
    int countTotalNum = list.countTotalNum();
    cout << "\n" << endl;
    cout << "Total musics in playlist: " << countTotalNum << endl;

    return 0;
}
