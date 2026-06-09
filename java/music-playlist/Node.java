public class Node {

    String songName;
    String artistName;
    Integer duration; // in minutes
    Node next;

    public Node(String songName, String artistName, Integer duration) {
        this.songName = songName;
        this.artistName = artistName;
        this.duration = duration;
    }
}
