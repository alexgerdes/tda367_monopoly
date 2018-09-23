
package edu.chalmers.tda367.service;

/**
 * Contract for any observer
 *
 * @author hajo
 */
public interface EventHandler {
  void onEvent(Event evt);
}
