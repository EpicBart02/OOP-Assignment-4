package assignment4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class fileHandler {
  
  private ArrayList<Star> system;
  
  Scanner scanner = new Scanner(System.in);
  
  public ArrayList<Star> getFileArray(){
    return new ArrayList<>(system);
  }

  public void setAllStars(ArrayList<Star> stars){
    system = new ArrayList<>(stars);
  }



  public void saveFile() {
    try {
      File savedata = new File("solarsystems.data");
      PrintWriter writeData = new PrintWriter(savedata);

      for (Star allStars : system) {
        writeData.println(allStars.getName() + ":" + allStars.getAvgRadiusInKm());
        for (Planet allPlanets : allStars.getAllPlanets()) {
          writeData.print("-" + allPlanets.getName() + ":" + allPlanets.getAvgRadiusInKm() + ":" + allPlanets.getAvgOrbitRadiusInKm());
          for (Moon allMoon : allPlanets.getAllMoons()) {
            writeData.println("--" + allMoon.getName() + ":" + allMoon.getAvgOrbitRadiusInKm() + ":" + allMoon.getAvgOrbitRadiusInKm());
          }
        }
      }
      writeData.close();

    } catch (IOException x) {
      System.out.println(x);
    }
  }
}
