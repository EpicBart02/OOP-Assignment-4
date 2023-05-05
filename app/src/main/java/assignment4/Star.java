package assignment4;

import java.util.ArrayList;

/**
 * A class for the star of the solarsystem.
 */

public class Star extends HeavenlyBody {
    
  private ArrayList<Planet> planets;

  /**
   * Constructor for star.
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
  
  /**
   * Remove planet method that also removes the moons if planet
   * is removed.
   */
  public void removePlanet(Planet planet) {
    for (Moon moon : planet.getAllMoons()) {
      planet.removeMoon(moon);
    }
    planets.remove(planet);
  }

  @Override
  protected void checkAvgRadiusInKm(int radius) {
    if (radius < 16700) {
      throw new IllegalArgumentException("Radius is out of bounds!");
    }
  }

}