/**
 * Test music player implementation
 *
 * @author David Saah
 * @since 09-10-2023
 * @version 1.0
 *
 */
class Problem1 {
  public static void main(String[] args) {
    /* Create 10 tracks */
    Song track1 = new Song("Trust In God", "Elevation Worship", "07:22", "CAN YOU IMAGINE?");
    Song track2 = new Song("Jehovah", "Elevation Worship", "05:54", "CAN YOU IMAGINE?");
    Song track3 = new Song("No Body", "Elevation Worship", "06:01", "CAN YOU IMAGINE?");
    Song track4 = new Song("Make A Way", "Elevation Worship", "08:32", "CAN YOU IMAGINE?");
    Song track5 = new Song("Been So Good", "Elevation Worship", "07:44", "CAN YOU IMAGINE?");
    Song track6 = new Song("LION", "Elevation Worship", "05:54", "LION");
    Song track7 = new Song("Welcome Resurrection", "Elevation Worship", "07:56", "LION");
    Song track8 = new Song("Same God", "Elevation Worship", "08:01", "LION");
    Song track9 = new Song("Water Is Wild", "Elevation Worship", "07:44", "LION");
    Song track10 = new Song("The One You Love", "Elevation Worship", "07:57", "LION");

    /* Set up music player */
    MusicPlayer gospel = new MusicPlayer();

    /* Load songs into music player */
    gospel.addSong(track1);
    gospel.addSong(track2);
    gospel.addSong(track3);
    gospel.addSong(track4);
    gospel.addSong(track5);
    gospel.addSong(track6);
    gospel.addSong(track7);
    gospel.addSong(track8);
    gospel.addSong(track9);
    gospel.addSong(track10);

    /* Show current playlist */
    gospel.display();
    System.out.println("Song count: " + gospel.listSize());
    System.out.println();

    /* Test playlist shuffle */
    System.out.println("Shuffling playlist...");
    System.out.println();
    gospel.shuffle();
    gospel.display();
    System.out.println("Song count: " + gospel.listSize());
    System.out.println();

    /* Play song */
    gospel.play();

    /* Play next song */
    System.out.println();
    System.out.println("Playing next track...");
    gospel.playNext();
    System.out.println();

    /* Play previous song */
    System.out.println();
    System.out.println("Playing previous track...");
    gospel.playPrevious();
    System.out.println();

    /* Remove 3 tracks */
    System.out.println("Removing 3 tracks...");
    System.out.println();
    gospel.removeSong(3);
    gospel.removeSong(5);
    gospel.removeSong(1);

    /* Show current playlist */
    gospel.display();
    System.out.println("Song count: " + gospel.listSize());
    System.out.println();
  }
}
