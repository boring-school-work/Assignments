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
   * Sets the title of the song
   *
   * @param title the title of the song
   *
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the song artist
   *
   * @return the artist of the song
   *
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Sets the artist of the song
   *
   * @param artist the artist of the song
   *
   */
  public void setArtist(String artist) {
    this.artist = artist;
  }

  /**
   * Gets the duration of the song
   * 
   * @return the duration of the song
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Sets the song's duration
   * 
   * @param the duration of the song
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }

  /**
   * Gets the album of the song belong to
   * 
   * @return song album
   */
  public String getAlbum() {
    return album;
  }

  /**
   * Sets the album of the song
   * 
   * @param the song album
   */
  public void setAlbum(String album) {
    this.album = album;
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
