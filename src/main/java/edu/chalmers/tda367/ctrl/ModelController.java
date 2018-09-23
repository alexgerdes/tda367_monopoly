package edu.chalmers.tda367.ctrl;

import edu.chalmers.tda367.core.Monopoly;

/**
 * An abstraction for classes that need to communicate with the model.
 *
 * @author alexg
 */
public interface ModelController {
  void connectModel(Monopoly monopoly);
}
