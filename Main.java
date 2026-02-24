public class Main {

  public static void main(String[] args) {

    PlayList list = new PlayList(null);
    Node node1 = new Node("X", "XX", 1);
    Node node2 = new Node("Y", "YY", 1);
    Node node3 = new Node("Z", "ZZ", 1);
    Node node4 = new Node("D", "DD", 1);
    list.insertNewSong(node1);
    list.insertNewSong(node2);
    list.insertNewSong(node3);
    list.insertNewSong(node4);
    String deleteSongName = list.deleteSongByName("Y");
    list.displayPlaylist();

    System.out.println("\n");
    System.out.println("Deleted song name " + deleteSongName);

    System.out.println("\n");
    System.out.println("Displaying next song of : " + node4.songName);
    list.playNextSong(node4);
    list.searchSongByName("X");
    int countTotalNum = list.countTotalNum();
    System.out.println("\n");
    System.out.println("Total musics in playlist: " + countTotalNum);
  }
}