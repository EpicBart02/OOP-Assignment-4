package assignment4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is made to handle loading and 
 * saving for my application.
 */
public class FileHandler {
  
  private ArrayList<Star> system;
  
  public ArrayList<Star> getFileArray() {
    return new ArrayList<>(system);
  }

  public void setAllStars(ArrayList<Star> stars) {
    system = new ArrayList<>(stars);
  }

  public void initializeSystem() {
    system = new ArrayList<>();
  }

  /**
   * This is my save file method.
   * It works by reading my array files and depending what type of heavenly body it is,
   * it writes them down with no or a maximum of two dashes followed by their information.
   */
  public void saveFile() {
    try {
      File savedata = new File("solarsystems.data");
      PrintWriter writeData = new PrintWriter(savedata);

      for (Star allStars : system) {
        writeData.println(allStars.getName() + ":" + allStars.getAvgRadiusInKm());
        for (Planet allPlanets : allStars.getAllPlanets()) {
          writeData.println("-" + allPlanets.getName() + ":" + allPlanets.getAvgRadiusInKm() + ":" 
              + allPlanets.getAvgOrbitRadiusInKm());
          for (Moon allMoon : allPlanets.getAllMoons()) {
            writeData.println("--" + allMoon.getName() + ":" + allMoon.getAvgRadiusInKm() + ":" 
                + allMoon.getAvgOrbitRadiusInKm());
          }
        }
      }
      writeData.close();

    } catch (IOException x) {
      System.out.println(x);
    }
  }


  /**
   * This is my loading method.
   * It works by first initializing currentStar and currentPlanet to null, 
   * and then it scans and tries to find out what type of string it scanned.
   * We deduce this by dashes, 0 dashes = 0 depth and that means star.
   * 1 Dash = 1 depth which means planet, and 2 dashes means 2 depth with in turn means moon.
   */

  public void loadFromFile() {
    try {
      //File savedata = new File("solarsystems.data");
      Scanner scanner = new Scanner(new File("solarsystems.data"));
      
      Star currentStar = null;
      Planet currentPlanet = null;
      
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        
        // Count the number of leading dashes to determine the depth of the entity in the hierarchy
        int depth = 0;
        while (line.startsWith("-")) {
          depth++;
          line = line.substring(1);
        }
        
        String[] parts = line.split(":");
        String name = parts[0];
        int radius = Integer.parseInt(parts[1]);
        
        if (depth == 0) {
          // Create a  new star
          currentStar = new Star(name, radius);
          system.add(currentStar);
        } else if (depth == 1) {
          // Create a new planet
          currentPlanet = new Planet(name, radius, Double.parseDouble(parts[2]));
          currentStar.addPlanet(currentPlanet);
        } else if (depth == 2) {
          // Create a new moon
          Moon moon = new Moon(name, radius, Double.parseDouble(parts[2]));
          currentPlanet.addMoon(moon);
        }
      }
      
      scanner.close();
    } catch (IOException e) {
      System.out.println("File not found: " + e);
    }
  } 

}
