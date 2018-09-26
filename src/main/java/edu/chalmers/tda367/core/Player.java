package edu.chalmers.tda367.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A single player of the game
 * Handles everything that has to do with a single player!
 *
 * @author alexg
 */
public class Player {
   // Simple id generator
  private final static AtomicInteger id_count = new AtomicInteger();

  private final Integer id;             // Unique identifier for the player
  private String name;
  //private final Piece piece;
  private int balance;
  private Space position;    // The actual position

  public Player(String name, Piece piece, int balance, Space position) {
    this.id = id_count.incrementAndGet();
    this.name = name;
    //this.piece = piece;
    this.balance = balance;
    this.position = position;
  }

  public Space getPosition() {
    return position;
  }

  public void setPosition(Space position) {
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void income(int amount) {
    balance += amount;
  }

  public int getBalance() {
    return balance;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) { return true; }
    if (other == null) { return false; }
    if (getClass() != other.getClass()) { return false; }
    Player o = (Player) other;
    return this.id == o.id;
  }
}
