package edu.chalmers.tda367.service;

import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Resources {
  private static Resources resources = null;
  private static ClassLoader classLoader;

  private Resources() {
    try {
      classLoader = Class.forName("edu.chalmers.tda367.App").getClassLoader(); // this.getClass().getClassLoader();
    } catch (Exception e){
      System.out.println("this should not happen!");
    }
  }

  public static Resources getInstance() {
    if (resources == null) resources = new Resources();

    return resources;
  }

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

  public static FXMLLoader getFXML(String name) {
    FXMLLoader loader = null;

    try {
      loader = new FXMLLoader(Resources.getURL(name));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return loader;
  }
}
