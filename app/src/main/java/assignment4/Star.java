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
    setName(name);
    checkAvgRadiusInKm(avgRadiusInKm);
    planets = new ArrayList<Planet>();
    new ArrayList<Moon>();
  }

  /**
   * Constructor for addPlanet.
   */

  public Planet addPlanet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Planet planet = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);
    planets.add(planet);
    return planet;
  }

  /**
   * Returns all heavenly bodies present in this solar systems.
   */

  public HeavenlyBody[] getHeavenlyBodies() {
    int length = planets.size() + 1;
    for (Planet planium : planets) {
      length += planium.moons.size();
    }
    HeavenlyBody[] copy = new HeavenlyBody[length];
    Star cope = new Star(getName(), getAvgRadiusInKm());
    copy[0] = cope;
    int checkster = 1;
    for (int i = 0; i < planets.size(); ++i) {
      Planet copium = new Planet(planets.get(i).getName(), planets.get(i).getAvgRadiusInKm(),
            planets.get(i).getAvgOrbitRadiusInKm());
      copy[checkster] = copium;
      checkster++;
    }
    for (Planet planium : planets) {
      for (Moon moonioom : planium.moons) {
        Moon copiummoon = new Moon(moonioom.getName(), moonioom.getAvgRadiusInKm(),
            moonioom.getAvgOrbitRadiusInKm());
        copy[checkster] = copiummoon;
        checkster++;
      }
    }
    return copy;
  }

  @Override
  protected void checkAvgRadiusInKm(int radius) {
    if (radius < 16700) {
      throw new IllegalArgumentException("Radius is out of bounds!");
    }
  }

  /**
   * Printing
   */
  public String toString() {
    String pin = getName() + getAvgRadiusInKm() + " \n "; 
    for (Planet i : planets) {
      pin += i;
    }
    return pin;
  }

  public void removeStar(Star star) {
    for (Planet planet : star.planets) {
        removePlanet(planet);
    }
    star = null;
}
public void removePlanet(Planet planet) {
    planet.removeMoon(planet);
    planets.remove(planet);
}

}
