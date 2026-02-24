public class Node {

  String songName;
  String artistName;
  Integer duration; // in minutes
  Node next;
  Node prev;

  public Node(String songName, String artistName, Integer duration, Node next) {
    this.songName = songName;
    this.artistName = artistName;
    this.duration = duration;
    this.next = next;
  }

  public Node(String songName, String artistName, Integer duration) {
    this.songName = songName;
    this.artistName = artistName;
    this.duration = duration;
  }
}