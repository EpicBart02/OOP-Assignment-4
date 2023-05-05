package assignment4;

/**
 * Abstract class for the different heavenly bodies.
 */
public abstract class HeavenlyBody {
  
  private String name;
  private Integer avgRadiusInKm;

  protected HeavenlyBody(String newName, int newAvgRadius) {
    setName(newName);
    setAvgRadiusInKm(newAvgRadius);
  }

  public String getName() {
    return name;
  }

  /**
   * SetName for heavenly bodies.
   */
  public void setName(String newName) {
    if (newName == null || newName.equals("")) {
      throw new IllegalArgumentException("Name cant be null or empty!");
    } else {
      this.name = newName;
    }
  }

  public Integer getAvgRadiusInKm() {
    return avgRadiusInKm;
  }
  
  public void setAvgRadiusInKm(int radius) {
    this.avgRadiusInKm = radius;
  }
  
  protected abstract void checkAvgRadiusInKm(int radius);
  
}

