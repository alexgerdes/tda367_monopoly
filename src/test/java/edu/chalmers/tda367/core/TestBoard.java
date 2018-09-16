package edu.chalmers.tda367.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Board is a bit complex so create test for it
 *
 * @author alexg
 */
public class TestBoard {
  @Test
  public void testBoardCreated() {
    Board board = Board.createMonopolyBoard();
    assertEquals(40, board.size());
    assertEquals("go", board.getStart().getName());
  }

  @Test
  public void testGetSpaceRelativeActual() {
    Board board = Board.createMonopolyBoard();
    Space space = board.getStart();

    assertEquals(space, board.getSpace(space, 0));  // taking null steps from the start is still the start

    space = board.getSpace(space, 10);  // take 10 steps
    assertEquals("jail", space.getName());  // we should end in jail

    space = board.getSpace(space, 10);  // take another 10 steps
    assertEquals("parking", space.getName());

    space = board.getSpace(space, 10);
    assertEquals("gotojail", space.getName());

    space = board.getSpace(space, 10);
    assertEquals(space, board.getStart());  // after 40 steps we should be on start again

    space = board.getSpace(space, 1);
    assertEquals("1:1", space.getName());
  }

  @Test
  public void testPassedGo() {
    Board board = Board.createMonopolyBoard();
    Space start = board.getStart();

    assertFalse(board.passesStart(start, board.getSpace(start, 1)));
    assertFalse(board.passesStart(board.getSpace("2:3"), board.getSpace("gotojail")));
    assertTrue(board.passesStart(board.getSpace("8:1"), board.getSpace("1:1")));
    assertTrue(board.passesStart(board.getSpace(start, 35), board.getSpace(start, 15)));
  }
}
