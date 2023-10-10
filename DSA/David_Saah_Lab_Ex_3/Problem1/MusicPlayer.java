import java.util.ArrayList;
import java.util.Random;

/**
 * Implement a music player using doubly linked list
 *
 * @author David Saah
 * @since 09-10-2023
 * @version 1.0
 *
 */
public class MusicPlayer {
  private int size = 0; // tracks the number of songs
  private Node head; // holds the address of the first song
  private Node tail; // holds the address of the last song
  private Node currentlyPlaying; // tracks the node of the currently playing song

  /**
   * Insert a song into playlist
   * 
   * @param data the song to insert into the playlist
   * @param pos  where to insert the song
   */
  public void addSong(Song track, int pos) {
    Node newNode = new Node(track);

    // if it is for inserting into the first song
    if (pos == 1) {
      newNode.next = head; // set the next node to point to the head
      newNode.prev = null; // set the previous node to point to null
      head = newNode; // set head to the new node
      size++; // increase the size of the playlist

      // if the size is 1, head = tail
      if (listSize() == 1) {
        tail = newNode;
      }

      return;
    }

    // if it is for inserting into the end of the playlist
    else if (pos == listSize() + 1) {
      newNode.prev = tail; // set the prev node to point to the end node
      tail.next = newNode; // set last node as newNode

      tail = newNode;
      size++; // increase the size
      return;
    }

    // insert the new node any where between the first and last node
    else {
      Node current = head; // point to the head

      // navigate to the node before the specified one
      for (int i = 1; i < (pos - 1); i++) {
        current = current.next;
      }

      newNode.next = current.next;
      newNode.prev = current;

      current.next.prev = newNode;
      current.next = newNode;

      size++;
      return;
    }
  }

  /**
   * Adds a song to the end of the playlist
   *
   * @param track the track to add to the end of the playlist
   */
  public void addSong(Song track) {
    Node newNode = new Node(track);

    if (listSize() == 0) {
      newNode.next = head; // set the next node to point to the head
      newNode.prev = null; // set the previous node to point to null
      head = newNode; // set head to the new node
      size++; // increase the size of the playlist

      tail = head;
      return;
    }

    newNode.prev = tail; // set the prev node to point to the end node
    tail.next = newNode; // set last node as newNode

    tail = newNode;
    size++; // increase the size
    return;
  }

  /**
   * Deletes a song when given a position
   *
   * @param pos location of a node
   */
  public void removeSong(int pos) {
    // if the playlist is empty
    if (isEmpty()) {
      return;
    }

    // if the first song is to be removed
    if (pos == 1) {
      head = head.next;
      size--;
      return;
    }

    // if the last song is to be removed
    else if (pos == listSize()) {
      tail = tail.prev;
      tail.next = null;
      size--;
      return;
    }

    // when deleting from anywhere in between
    else {
      Node current = head; // set current node to head

      // navigate to the node before the specified one
      for (int i = 1; i < (pos - 1); i++) {
        current = current.next;
      }

      current.next = current.next.next;
      current.next.prev = current;
      size--; // reduce the size
      return;
    }

  }

  /**
   * Deletes a song node
   *
   * @param song the node to remove from the playlist
   */
  private void removeSong(Node song) {
    Node current = head; // set current node to head

    // if the song is at the beginning
    if (head.equals(song)) {
      head = head.next;
      size--;
      return;
    }

    // if the song is at the ending
    if (tail.equals(song)) {
      tail = tail.prev;
      tail.next = null;
      size--;
      return;
    }

    // if it is anywhere between
    while (!current.equals(song)) {
      current = current.next;
    }

    current = current.next;
    current.prev = current;
    size--;
    return;
  }

  /**
   * Check if the playlist is empty
   * 
   * @return whether the playlist is empty or not
   */
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Gets the size of the playlist
   * 
   * @return the size of the playlist
   */
  public int listSize() {
    return size;
  }

  /**
   * Plays a song starting from the head
   */
  public void play() {
    System.out.println("Currently playing: " + head.data.toString()); // display song info
    currentlyPlaying = head; // set the currently playing track
  }

  /**
   * Plays a song from a node
   * 
   * @param song the node of track to play
   */
  private void play(Node song) {
    System.out.println("Currently playing: " + song.data.toString());
    currentlyPlaying = song;
  }

  /**
   * Plays the next track in the playlist
   */
  public void playNext() {
    if (tail.equals(currentlyPlaying)) {
      System.out.println("You have reached the end of the playlist");
      currentlyPlaying = null;
      return;
    }

    play(currentlyPlaying.next);
  }

  /**
   * Plays the previous track in the playlist
   */
  public void playPrevious() {
    if (head.equals(currentlyPlaying)) {
      System.out.println("This is the beginning of the playlist. Cannot set previous track.");
      return;
    }

    play(currentlyPlaying.prev);
  }

  /**
   * Gets the track at the specified position
   * 
   * @param pos position of the track
   * @return the node at the specified position in the playlist
   */
  private Node get(int pos) {
    Node current = head;

    for (int i = 1; i < pos; i++) {
      current = current.next;
    }

    return current;
  }

  /**
   * Randomly reorders the playlist
   */
  public void shuffle() {
    ArrayList<Integer> nums = new ArrayList<Integer>(); // hold nums from 1 to size of playlist

    for (int i = 1; i <= listSize(); i++) {
      nums.add(i); // populate nums
    }

    // shuffle playlist till nums is empty
    while (!nums.isEmpty()) {
      int pos;

      if (nums.size() == 1) {
        pos = nums.get(0);
      } else {
        pos = new Random().nextInt(1, nums.size()); // get a random position
      }

      Node current = get(pos); // get a random node
      addSong(current.data); // add track to the playlist
      removeSong(current); // remove the selected node from the playlist (first occurence)
      nums.removeLast(); // remove last position
    }
  }

  /**
   * Displays the current playlist
   */
  public void display() {
    Node current = head;

    System.out.println("CURRENT PLAYLIST");
    System.out.println("-".repeat(20));

    while (current != null) {
      System.out.print(current.data.toString());
      System.out.println();
      current = current.next;
    }

    System.out.println();
  }
}

/**
 * A node contains data and a reference
 *
 */
class Node {
  Song data; // holds the data of a node (a song)
  Node next; // holds the pointer to the next node
  Node prev; // holds the pointer to the prev node

  public Node(Song data) {
    this.data = data;
  }

  /**
   * Check if any two songs are the same
   *
   * @param otherSong the other song to compare with
   * @return whether the songs are the same
   *
   */
  public boolean equals(Node otherSong) {
    return this.data.getTitle().equalsIgnoreCase(otherSong.data.getTitle());
  }
}
