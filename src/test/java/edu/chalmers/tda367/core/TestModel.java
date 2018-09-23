package edu.chalmers.tda367.core;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Her we run integration tests (more participation objects and full use cases)
 *
 * @author alexg
 */
public class TestModel {
  private final String[] PLAYER_NAMES = {"olle", "fia", "allan", "siv"};
  private Monopoly m;

  @Before
  public void before() {
    m = Monopoly.createMonopoly(Arrays.asList(PLAYER_NAMES));  // Initialize model
  }

  @Test
  public void testModelCreated() {  // TODO Not a good name!
    m.getPlayers().forEachRemaining(p -> {
      assertEquals("go", p.getPosition().getName());
    });

    assertEquals("go", m.getActivePlayer().getPosition().getName());
  }

  @Test
  public void testMove() {
    final int score = 3;
    m.setDices(new MockDices(score));

    Player p = m.getActivePlayer();
    m.move();

    assertEquals(p, m.getActivePlayer());  // No player change after move, only after change turn
    Space start = m.getSpaces().next();
    assertEquals(getSpace(score*2), p.getPosition());
  }

  private Space getSpace(int index) {
    Iterator<Space> iterator = m.getSpaces();
    Space space = null;

    for (int i = 0; i <= index && iterator.hasNext(); i++)
      space = iterator.next();

    return space;
  }

  @Test
  public void testMoveAndPassGo() {
    Player player = m.getActivePlayer();
    int startBalance = player.getBalance();
    player.setPosition(getSpace(30));
    m.setDices(new MockDices(12));  // make sure we pass start
    m.move();
    assertEquals(player.getBalance(), startBalance + Monopoly.BONUS);
  }

  @Test
  public void testEndTurn() {
    Player startPlayer = m.getActivePlayer();

    // cycle through all players
    m.getPlayers().forEachRemaining(p -> {
      m.changeTurn();
    });

    assertEquals(startPlayer, m.getActivePlayer());
  }
}
