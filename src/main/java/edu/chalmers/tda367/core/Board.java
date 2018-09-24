package edu.chalmers.tda367.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a monopoly board. The spaces are represented by a list.
 *
 * @author alexg
 */
class Board {
  private final List<Space> spaces;

  /**
   * A factory method for creating a Monopoly board,
   *
   * @return a new Monopoly board.
   */
  public static Board createMonopolyBoard() {
    // This will later come from file
    String spaceNames
        = "go,1:1,cc1,1:2,income,train1,2:1,chance1,2:2,2:3,"
        + "jail,3:1,electric,3:2,3:3,train2,4:1,cc2,4:2,4:3,"
        + "parking,5:1,chance2,5:2,5:3,train3,6:1,6:2,water,6:3,"
        + "gotojail,7:1,7:2,cc3,7:3,train4,chance3,8:1,luxury,8:2";

    return new Board(spaceNames);
  }

  private Board(String txt) {
    this.spaces = parseSpaces(txt);
  }

  private List<Space> parseSpaces(String txt) {
    List<Space> sps = new ArrayList<Space>();

    for (String name : txt.split(",")) {
      sps.add(new Space(name));
    }

    return sps;
  }

  /**
   * The number of spaces on the board.
   *
   * @return number of spaces
   */
  public int size() {
    return spaces.size();
  }

  /**
   * Return the start space, name 'Start'
   *
   * @return a reference to the start place
   */
  public Space getStart() {
    return spaces.get(0);
  }

  /**
   * Does the path between @start@ and @end@ pass 'Start' (the start space)?
   *
   * @param start space where the path starts, for example @Player@ current space
   * @param end   space where the path ends, for example @Player@'s destiny
   * @return True if landing on or passing 'Start' (not leaving)
   */
  public boolean passesStart(Space start, Space end) {
    return spaces.indexOf(start) > spaces.indexOf(end);
  }

  /**
   * Retrieve the space with the given name.
   *
   * @param name name of the space
   * @return a reference to the space otherwise null
   */
  public Space getSpace(String name) {
    for (Space s : spaces)
      if (s.getName().equals(name))
        return s;

    return null;
  }

  /**
   * Get the space n steps form the given space
   * @param start start at the given space
   * @param steps take this amount of steps
   * @return the space we land on after @steps@ steps
   */
  public Space getSpace(Space start, int steps) {
    int oldPos = spaces.indexOf(start);
    int newPos = (oldPos + steps) % spaces.size();
    return spaces.get(newPos);
  }

  public Iterator<Space> getSpaces() {
    return spaces.iterator();
  }

  @Override
  public String toString() {
    return "Board{" + spaces + '}';
  }
}
