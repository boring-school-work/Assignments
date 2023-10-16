/**
 * Implement a Song class to define the structure and behaviour of songs
 *
 * @author David Saah
 * @since 09-10-2023
 * @version 1.0
 *
 */
public class Song {
  private String title;
  private String artist;
  private String duration;
  private String album;

  /**
   * Initialises a new song
   *
   * @param title    the title of the song
   * @param artist   the song artist
   * @param duration the song duration
   * @param album    the song album
   */
  public Song(String title, String artist, String duration, String album) {
    this.title = title;
    this.artist = artist;
    this.duration = duration;
    this.album = album;
  }

  /**
   * Gets the title of the song
   *
   * @return the title of the song
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets information about a song
   *
   * @return song info
   */
  @Override
  public String toString() {
    return "Song [ title: " + title + ", artist: " + artist + ", duration: " + duration + ", album: " + album + " ]";
  }

}
