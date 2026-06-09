import java.util.Objects;

public class PlayList {

    private Node node;

    public PlayList(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void displayPlaylist() {
        Node temp = this.node;
        while (temp != null) {
            System.out.println("\n");
            System.out.println("Song name " + temp.songName);
            System.out.println("artist name " + temp.artistName);
            System.out.println("duration " + temp.duration);

            temp = temp.next;
        }
    }

    public void insertNewSong(Node newNode) {
        newNode.next = this.node;
        this.node = newNode;
    }

    public String deleteSongByName(String songName) {
        String song = "";
        if (this.node == null) {
            System.out.println("List is empty");
        } else if (Objects.equals(this.node.songName, songName)) {
            song = this.node.songName;
            this.node = this.node.next;
            return song;
        }
        Node curr = this.node;
        Node prev = null;

        while (curr != null) {
            if (Objects.equals(curr.songName, songName)) {
                song = curr.songName;
                Objects.requireNonNull(prev).next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        return song;
    }

    public void playNextSong(Node node) {
        if (node == null) {
            System.out.println("PlayList is empty");
        } else {
            System.out.println("\n");
            System.out.println("Song name " + node.next.songName);
            System.out.println("artist name " + node.next.artistName);
            System.out.println("duration " + node.next.duration);
        }
    }

    public void searchSongByName(String name) {
        Node curr = this.node;
        boolean isFound = false;
        while (curr != null) {
            if (Objects.equals(curr.songName, name)) {
                System.out.println("\n");
                System.out.println("Song was found");
                System.out.println("Song name " + curr.songName);
                System.out.println("artist name " + curr.artistName);
                System.out.println("duration " + curr.duration);
                isFound = true;
            }
            curr = curr.next;
        }

        if (!isFound) {
            System.out.println("Song doesn't exist");
        }
    }

    public int countTotalNum() {
        int count = 0;
        Node curr = this.node;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
