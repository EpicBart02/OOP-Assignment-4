package assignment4;

import java.util.ArrayList;

/**
* Heavenlybody abstract class extend.
*/

public class Planet extends HeavenlyBody {
  
  private double avgOrbitRadiusInKm;
  ArrayList<Moon> moons;
  
  /**
  * Constructor for planet.
  */
  
  protected Planet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    setName(name);
    checkAvgRadiusInKm(avgRadiusInKm);
    if (avgOrbitRadiusInKm < 18000) {
      throw new IllegalArgumentException("Orbit radius is out of bounds!");
    } else {
      this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    }
    moons = new ArrayList<Moon>();
  }
  
  /**
  * A method to add moons to the planet.
  */
  
  public Moon addMoon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    if (avgRadiusInKm > super.getAvgRadiusInKm() / 2) {
      throw new IllegalArgumentException("Out of bounds!");
    }
    
    Moon moon = new Moon(name, avgRadiusInKm, avgOrbitRadiusInKm);
    for (HeavenlyBody i : moons) {
      if (i.getName().equals(name))  {
        throw new IllegalArgumentException("Moon is already present!");
      }
    }
    moons.add(moon);
    return moon;
  }
  
  public double getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }
  
  /**
  * Returns array.
  */
  
  public HeavenlyBody[] getHeavenlyBodies() {
    HeavenlyBody[] copy = new HeavenlyBody[moons.size() + 1];
    Planet copy2 = new Planet(getName(), getAvgRadiusInKm(), getAvgOrbitRadiusInKm());
    copy[0] = copy2;
    for (int i = 1; i < moons.size() + 1; ++i) {
      Moon copies = new Moon(moons.get(i - 1).getName(), moons.get(i - 1).getAvgRadiusInKm(),
      moons.get(i - 1).getAvgOrbitRadiusInKm());
      copy[i] = copies;
    }
    return copy;
  }
  
  @Override
  protected void checkAvgRadiusInKm(int radius) {
    if (radius < 2000 || radius > 200000) {
      throw new IllegalArgumentException("Radius is out of bounds!");
    }
  }
  
  /**
  * Printing.
  */
  public String toString() {
    String in = "Planet:" + getName() + " average radius " + getAvgRadiusInKm() + "km " + 
    "average orbit radius " + getAvgOrbitRadiusInKm() + "km" + " \n ";
    for (Moon i : moons) {
      in += i;
    }
    return in;
  }
}
