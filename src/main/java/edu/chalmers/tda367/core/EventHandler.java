
package edu.chalmers.tda367.core;

/**
 * Contract for any observer
 *
 * @author hajo
 */
public interface EventHandler {
  void onEvent(Event evt);
}
