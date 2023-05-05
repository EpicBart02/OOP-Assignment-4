package assignment4;

/**
 * Moon.
 */

public class Moon extends HeavenlyBody {
  
  private double avgOrbitRadiusInKm;

  protected Moon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    setavgOrbitRadiusInKm(avgOrbitRadiusInKm);
  }

  private void setavgOrbitRadiusInKm(double avgOrbit) {
    if (avgOrbit > 6.0 || avgOrbit < 15000.0) {
      this.avgOrbitRadiusInKm = avgOrbit;
    } else {
      throw new IllegalArgumentException("Choose another number so it doesnt collide");
    }
  }

  public double getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }

  @Override
  protected void checkAvgRadiusInKm(int radius) {
    if (radius < 6 || radius > 10000) {
      throw new IllegalArgumentException("Radius is out of bounds!");
    }
  }
}
