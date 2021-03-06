package edu.chalmers.tda367.core;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * The overall (aggregate) model of our monopoly game.
 *
 * @author alexg
 */
public class Monopoly {
  // Application wide constants, TODO (possibly configurable )
  public static final int BALANCE = 1000;
  public static final int BONUS = 100;

  private final List<Player> players;
  private Dices dices;
  private final Board board;
  private Player activePlayer;

  public static Monopoly createMonopoly(List<String> names) {
    return new Monopoly(names);
  }

  private Monopoly(List<String> names) {
    this.dices   = new Dices();
    this.board   = Board.createMonopolyBoard();
    this.players = new ArrayList<Player>();

    Space start = board.getStart();

    for (String name : names)
      players.add(new Player(name, null, BALANCE, start));

    this.activePlayer = randomElement(players);
  }

  private <A> A randomElement(List<A> list) {
    Random random = new Random();
    return list.get(random.nextInt(list.size()));
  }

  /**
   * Change the turn to the next player.
   */
  public void changeTurn() {
    int i  = players.indexOf(activePlayer);
    activePlayer = players.get((i + 1) % players.size());
  }

  /**
   * Move the activePlayer player to the next space based on the roll of the dices.
   */
  public Pair<Integer, Integer> move() {
    Space currentSpace = activePlayer.getPosition();
    dices.roll();  // TODO GUI updated using observer
    Space nextSpace = board.getSpace(currentSpace, dices.getTotal());
    activePlayer.setPosition(nextSpace);

    if (board.passesStart(currentSpace, nextSpace))
      activePlayer.income(BONUS);  // TODO GUI updated using observer

    return dices.getValues();  // TODO change to observer (or eventbus) later
  }

  public Iterator<Player> getPlayers() {
    return players.iterator();
  }

  public Iterator<Space> getSpaces() {
    return board.getSpaces();
  }

  /**
   * Player who is in turn.
   *
   * @return active player
   */
  public Player getActivePlayer() {
    return activePlayer;
  }

  // test function
  void setDices(Dices dices) {
    this.dices = dices;
  }
}
