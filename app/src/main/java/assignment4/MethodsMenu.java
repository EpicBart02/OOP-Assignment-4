package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Class for handling all add, delete and sort methods for the app.
 */
public class MethodsMenu {

  private ArrayList<Star> system;
  
  
  //Getter and setter for the private arraylist variable:
  public ArrayList<Star> getAllStars() {
    return new ArrayList<>(system);
  }

  public void setAllStars(ArrayList<Star> stars) {
    system = new ArrayList<>(stars);
  }
  
  /**
   * Create star method.
   */
  public void createStar(Scanner inputLine) {
    
    System.out.println("Please enter the name for the star: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the average radius for the star: ");
    Integer starRadius = inputLine.nextInt();
    
    Star star = new Star(starName, starRadius);
    //If star already exists, throw an error.
    
    if (system.contains(star)) {
      throw new IllegalArgumentException("Star is already present, enter new information again,");
    }
    system.add(star);
  }
  
  
  /**
   * Remove star method.
   */
  public void removeStar(Scanner inputLine) {
    System.out.println("Enter the name of the star you want to delete: ");
    String starName = inputLine.nextLine();
    
    /*Searching for a star with the same name in the system using iterator.
    If a match is found, we delete it from the system.*/
    Iterator<Star> iterator = system.iterator();
    while (iterator.hasNext()) {
      Star star = iterator.next();
      if (star.getName().equals(starName)) {
        iterator.remove();
      }
    }
  }
  
  /**
   * Create planet method, takes inputs.
   */
  public void createPlanet(Scanner inputLine) {
    System.out.println("Please enter which star this planet belongs to: ");
    String planetInheretance = inputLine.nextLine();
    
    System.out.println("Please enter the name of the planet");
    String planetName = inputLine.nextLine();
    
    System.out.println("Please enter the average radius in km: ");
    Integer planetRadius = inputLine.nextInt();
    
    System.out.println("Please enter the average orbit radius: ");
    Integer planetOrbit = inputLine.nextInt();
    
    Planet createdPlanet = new Planet(planetName, planetRadius, planetOrbit);
    
    for (Star allStars : system) {
      if (allStars.getName().equals(planetInheretance)) {
        allStars.addPlanet(createdPlanet);
      }
    }
  }
  
  /**
   * Remove planet method, takes input aswell.
   */
  public void removePlanet(Scanner inputLine) {
    
    System.out.println("Please enter the name of the Star where the planet resides: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the planet you want to delete: ");
    String planetName = inputLine.nextLine();
    
    for (Star allStars : system) {
      if (allStars.getName().equals(starName)) {
        for (Planet allPlanet : allStars.getAllPlanets()) {
          if (allPlanet.getName().equals(planetName)) {
            allStars.removePlanet(allPlanet);
          }
        }
      }
    }
  }
  
  /**
   * Create moon method.
   */
  public void createMoon(Scanner inputLine) {
    System.out.println("Please enter the name of the star the moon belongs to: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the planet that the moon belongs to: ");
    String planetName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the moon: ");
    String moonName = inputLine.nextLine();
    
    System.out.println("Please enter the average radius of the moon: ");
    Integer moonRadius = inputLine.nextInt();
    
    System.out.println("Please enter the moons average orbit radius");
    Integer moonOrbit = inputLine.nextInt();
    
    Moon createdMoon = new Moon(moonName, moonRadius, moonOrbit);
    
    for (Star allstars : system) {
      if (allstars.getName().equals(starName)) {
        for (Planet allPlanet : allstars.getAllPlanets()) {
          if (allPlanet.getName().equals(planetName)) {
            allPlanet.addMoon(createdMoon);
          }
        }
      }
    }
    
  }
  
  /**
   * Remove moon method.
   */
  public void removeMoon(Scanner inputLine) {
    
    System.out.println("Please enter the name of the star the moon belongs to: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the planet that the moon belongs to: ");
    String planetName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the moon: ");
    String moonName = inputLine.nextLine();
    
    for (Star allstars : system) {
      if (allstars.getName().equals(starName)) {
        for (Planet allPlanet : allstars.getAllPlanets()) {
          if (allPlanet.getName().equals(planetName)) {
            for (Moon moons : allPlanet.getAllMoons()) {
              if (moons.getName().equals(moonName)) {
                allPlanet.removeMoon(moons);
              }
            }
          }
        }
      }
    }
  }


  /**
   * Sorting everything by orbit radius.
   */
  
  public void sortByOrbit() {
    for (Star star : system) {
      List<Planet> allPlanet = star.getAllPlanets();
      Collections.sort(allPlanet, new Comparator<Planet>() {
        @Override
        public int compare(Planet firstPlanet, Planet secondPlanet) {
          return Double.compare(firstPlanet.getAvgOrbitRadiusInKm(), secondPlanet.getAvgOrbitRadiusInKm());
        }
      });

      //sort out the stars planets and later on we will print them out.
      System.out.println("Sorted planets for " + star.getName() + ":");
      for (Planet planet : allPlanet) {
        List<Moon> moons = planet.getAllMoons();
        Collections.sort(moons, new Comparator<Moon>() {
          @Override
          public int compare(Moon firstMoon, Moon secondMoon) {
            System.out.println(firstMoon.getAvgOrbitRadiusInKm() + " " + secondMoon.getAvgOrbitRadiusInKm());
            return Double.compare(firstMoon.getAvgOrbitRadiusInKm(), secondMoon.getAvgOrbitRadiusInKm());
          }
        });
        //For each sorted planet, print out its sorted moon.
        System.out.println("-" + planet.getName() + ":" + planet.getAvgOrbitRadiusInKm());
        for (Moon moon : moons) {
          System.out.println("--" + moon.getName() + ":" + moon.getAvgOrbitRadiusInKm());
        }
      }


    }
  }


  /**
   * Sorting everything by size (avgRadiusInKm).
   */
  
  public void sortBySize() {

    for (Star star : system) {
      List<Planet> allPlanet = star.getAllPlanets();
      Collections.sort(allPlanet, new Comparator<Planet>() {
        @Override
        public int compare(Planet firstPlanet, Planet secondPlanet) {
          return Integer.compare(firstPlanet.getAvgRadiusInKm(), secondPlanet.getAvgRadiusInKm());
        }
      });

      System.out.println("Sorted planets for " + star.getName() + ":");
      for (Planet planet : allPlanet) {
        List<Moon> moons = planet.getAllMoons();
        Collections.sort(moons, new Comparator<Moon>() {
          @Override
          public int compare(Moon firstMoon, Moon secondMoon) {
            System.out.println(firstMoon.getAvgRadiusInKm() + " " + secondMoon.getAvgRadiusInKm());
            return Double.compare(firstMoon.getAvgRadiusInKm(), secondMoon.getAvgRadiusInKm());
          }
        });
        System.out.println("-" + planet.getName() + ":" + planet.getAvgRadiusInKm());
        for (Moon moon : moons) {
          System.out.println("--" + moon.getName() + ":" + moon.getAvgRadiusInKm());
        }
      }
    }
  }
}

