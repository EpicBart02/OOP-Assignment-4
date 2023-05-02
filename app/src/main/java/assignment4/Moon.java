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
    this.avgOrbitRadiusInKm = avgOrbit;
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

  protected void printToString() {
    System.out.println("Moon: " + this.getName() + ", average radius in km: " + this.getAvgRadiusInKm()
    + ", " + "Average orbit radius: " + this.getAvgOrbitRadiusInKm());
  }
}
