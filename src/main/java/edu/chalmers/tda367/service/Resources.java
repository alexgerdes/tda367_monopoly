package edu.chalmers.tda367.service;

import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Resources {
  public static URL getURL(String name) throws IOException {
    URL url = Resources.class.getClassLoader().getResource(name);

    if (url != null)
      return url;
    else
      throw new IOException("Could not load resource: " + name);
  }

  public static File getFile(String name) throws IOException {
    return new File(getURL(name).getFile());
  }

  public static <C> C getFXML(String name) {
    C controller = null;

    try {
      FXMLLoader loader = new FXMLLoader(Resources.getURL(name));
      loader.load();
      controller = loader.getController();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return controller;
  }
}
