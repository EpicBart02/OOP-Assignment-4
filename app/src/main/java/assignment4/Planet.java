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
    setavgOrbitRadiusInKm(avgOrbitRadiusInKm);
    moons = new ArrayList<>();
  }
  
  /**
   * A getter for the arraylist filled with moons.
   */
  
  public ArrayList<Moon> getAllMoons() {
    return new ArrayList<>(moons);
  }

  /**
  * Two methods. One adds moon to the array list,
  * one removes moon from arraylist.
  */


  public void addMoon(Moon moon) {
    moons.add(moon);
  }

  public void removeMoon(Moon moon) {
    moons.remove(moon);
}
  
  /**
   * A getter and setter for avg orbit radius.
   */

  public double getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }

  private void setavgOrbitRadiusInKm(double avgOrbit) {
    if (avgOrbit > 1000.0 || avgOrbit < 30000.0) {
      this.avgOrbitRadiusInKm = avgOrbit;
    } else {
      throw new IllegalArgumentException("Choose another number so it doesnt collide");
    }
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
  protected void printToString() {
    System.out.println("Planet:" + getName() + " average radius " + getAvgRadiusInKm() + "km " + 
    "average orbit radius " + getAvgOrbitRadiusInKm() + "km" + " \n ");
    for (Moon i : moons) {
      i.toString();
    }
  }

}
