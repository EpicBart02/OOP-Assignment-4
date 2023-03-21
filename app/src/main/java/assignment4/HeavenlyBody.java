package assignment4;

public abstract class HeavenlyBody {
  
  private String name;
  private Integer avgRadiusInKm;

  protected HeavenlyBody(String newName, int newAvgRadius) {
    this.name = newName;
    this.avgRadiusInKm = newAvgRadius;
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    if (newName == null || newName == "") {
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
  
  public String toString() {
    return getName() + "  " + getAvgRadiusInKm() + "km";
  }
  
  public int compareTo(HeavenlyBody clk) {
    if (getAvgRadiusInKm() == clk.getAvgRadiusInKm()) {
      return 0;
    } else if (getAvgRadiusInKm() > clk.getAvgRadiusInKm()) {
      return 1;
    } else {
      return -1;
    }
  }
}

