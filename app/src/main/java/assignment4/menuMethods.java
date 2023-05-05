package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class menuMethods {
  
  private ArrayList<Star> system;
  
  
  //Getter and setter for the private arraylist variable:
  public ArrayList<Star> getAllStars() {
    return new ArrayList<>(system);
  }
  public void setAllStars(ArrayList<Star> stars) {
    system = new ArrayList<>(stars);
  }
  
  Scanner scanner = new Scanner(System.in);
  
  public void createStar(Scanner inputLine) {
    
    System.out.println("Please enter the name for the star: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the average radius for the star: ");
    Integer starRadius = inputLine.nextInt();
    
    Star star = new Star(starName, starRadius);
    //If star already exists, throw an error.
    
    if(system.contains(star)) {
      throw new IllegalArgumentException("Star is already present, enter new information again,");
    }
    system.add(star);
  }
  
  
  
  public void removeStar(Scanner inputLine) {
    System.out.println("Enter the name of the star you want to delete: ");
    String starName = inputLine.nextLine();
    
    //Searching for a star with the same name in the system using iterator. If a match is found, we delete it from the system.
    Iterator<Star> iterator = system.iterator();
    while(iterator.hasNext()) {
      Star star = iterator.next();
      if(star.getName().equals(starName)) {
        iterator.remove();
      }
    }
  }
  
  
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
    
    for(Star allStars : system) {
      if(allStars.getName().equals(planetInheretance)) {
        allStars.addPlanet(createdPlanet);
      }
    }
  }
  
  
  public void removePlanet(Scanner inputLine) {
    
    System.out.println("Please enter the name of the Star where the planet resides: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the planet you want to delete: ");
    String planetName = inputLine.nextLine();
    
    for(Star allStars: system) {
      if(allStars.getName().equals(starName)) {
        for(Planet allPlanet : allStars.getAllPlanets()) {
          if(allPlanet.getName().equals(planetName)) {
            allStars.removePlanet(allPlanet);
          }
        }
      }
    }
  }
  
  
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
    
    for(Star allstars : system) {
      if(allstars.getName().equals(starName)) {
        for(Planet allPlanet : allstars.getAllPlanets()) {
          if(allPlanet.getName().equals(planetName)) {
            allPlanet.addMoon(createdMoon);
          }
        }
      }
    }
    
  }
  
  public void removeMoon(Scanner inputLine) {
    
    System.out.println("Please enter the name of the star the moon belongs to: ");
    String starName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the planet that the moon belongs to: ");
    String planetName = inputLine.nextLine();
    
    System.out.println("Please enter the name of the moon: ");
    String moonName = inputLine.nextLine();
    
    for(Star allstars : system) {
      if(allstars.getName() == starName) {
        for(Planet allPlanet : allstars.getAllPlanets()) {
          if(allPlanet.getName() == planetName) {
            for(Moon moons : allPlanet.getAllMoons()) {
              if(moons.getName() == moonName) {
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
        public int compare(Planet first_planet, Planet second_planet) {
          return Double.compare(first_planet.getAvgOrbitRadiusInKm(), second_planet.getAvgOrbitRadiusInKm());
        }
      });

      //sort out the stars planets and later on we will print them out.
      System.out.println("Sorted planets for " + star.getName() + ":");
      for (Planet planet : allPlanet) {
        List<Moon> moons = planet.getAllMoons();
        Collections.sort(moons, new Comparator<Moon>() {
          @Override
          public int compare(Moon first_Moon, Moon second_Moon) {
            System.out.println(first_Moon.getAvgOrbitRadiusInKm() + " " + second_Moon.getAvgOrbitRadiusInKm());
            return Double.compare(first_Moon.getAvgOrbitRadiusInKm(), second_Moon.getAvgOrbitRadiusInKm());
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
        public int compare(Planet first_planet, Planet second_planet) {
          return Integer.compare(first_planet.getAvgRadiusInKm(), second_planet.getAvgRadiusInKm());
        }
      });

      System.out.println("Sorted planets for " + star.getName() + ":");
      for (Planet planet : allPlanet) {
        List<Moon> moons = planet.getAllMoons();
        Collections.sort(moons, new Comparator<Moon>() {
          @Override
          public int compare(Moon first_Moon, Moon second_Moon) {
            System.out.println(first_Moon.getAvgRadiusInKm() + " " + second_Moon.getAvgRadiusInKm());
            return Double.compare(first_Moon.getAvgRadiusInKm(), second_Moon.getAvgRadiusInKm());
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
