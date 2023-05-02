package assignment4;

import java.util.ArrayList;

/**
 * A class for the star of the solarsystem.
 */

public class Star extends HeavenlyBody {
    
  private ArrayList<Planet> planets;

  /**
   * Constructor for star
   */

  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    planets = new ArrayList<>();
  }

  /**
   * A getter for the planets arraylist.
   */

  public ArrayList<Planet> getAllPlanets() {
    return new ArrayList<>(planets);
  }

  /**
   * Two methods that add and remove planets from the stars arraylist.
   * Additionally, if a planet is removed, all of its moons get removed aswell.
   */

  public void addPlanet(Planet addedPlanet) {
    planets.add(addedPlanet);
  }

  public void removePlanet(Planet planet) {
    for(Moon moon : planet.getAllMoons()){
      planet.removeMoon(moon);
    }
    planets.remove(planet);
  }


  /*public void addPlanet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Planet planet = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);
    planets.add(planet);
    //return planet;
  }*/

  @Override
  protected void checkAvgRadiusInKm(int radius) {
    if (radius < 16700) {
      throw new IllegalArgumentException("Radius is out of bounds!");
    }
  }

  /**
   * Printing
   */
  public void printToString() {
    System.out.println("Star: " + this.getName() + ", Average radius in km: " + getAvgRadiusInKm());
    for (Planet allPlanet : planets) {
      allPlanet.toString();
    }
  }

}