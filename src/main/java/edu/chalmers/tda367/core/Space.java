package edu.chalmers.tda367.core;

/**
 * This class represents a space (i.e., a tile) on the monopoly board. A space
 * can be a street, railroad, corner, etc., and can be occupied by players. Will
 * be a base class in the future.
 *
 * @author alexg
 */
public final class Space {
  private final String name;  // Name of the space

  public Space(String name) {
    this.name = name;
  }

  /**
   * Retrieve the name of the space.
   *
   * @return the name of the space.
   */
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Space space = (Space) o;

    return name != null ? name.equals(space.name) : space.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Space{name = " + name + "}";
  }
}
