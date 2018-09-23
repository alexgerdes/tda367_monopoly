package edu.chalmers.tda367.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Very simple event bus. All observers can register for events and an
 * observable can publish (send) events.
 *
 * @author alex
 */
public class EventBus {
  private final List<EventHandler> handlers;
  private boolean trace = true;

  public EventBus(boolean trace) {
    handlers = Collections.synchronizedList(new ArrayList<>());  // make it threadsafe
    this.trace = trace;
  }

  /**
   * Disable or enable tracing to stdout
   *
   * @param trace tracing on or off
   */
  public void setTrace(boolean trace) {
    this.trace = trace;
  }

  /**
   * Register an event handler.
   *
   * @param handler the event handler
   */
  public void register(EventHandler handler) {
    handlers.add(handler);
  }

  /**
   * Remove an event handler.
   *
   * @param handler the event handler
   */
  public void unRegister(EventHandler handler) {
    handlers.remove(handler);
  }

  /**
   * Notify all event handlers.
   *
   * @param evt the event
   */
  public void publish(Event evt) {
    if (trace)
      System.out.println(evt);

    synchronized (handlers) {
      handlers.forEach(evh -> { evh.onEvent(evt); });
    }
  }
}
