package assignment4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class menuMethods {

  private ArrayList<Star> system;

  Scanner scanner = new Scanner(System.in);


  //Getter and setter for the private arraylist variable:
  public ArrayList<Star> getAllStars() {
    return system;
  }

  public void setAllStars() {
    system = new ArrayList<>();
  }


  public void createStar(Scanner inputLine) {

    System.out.println("Please enter the name for the star: ");
    String starName = inputLine.nextLine();

    System.out.println("Please enter the average radius for the star: ");
    Integer starRadius = inputLine.nextInt();

    Star star = new Star(starName, starRadius);
    //If star already exists, throw an error.
    if(system.contains(star)) {
      throw new IllegalArgumentException("Star is already present, enter new information again,");
    } else {
      system.add(star);
    }
  }

  public void removeStar(Scanner inputLine) {
    System.out.println("Enter the name of the star you want to delete: ");
    String starName = inputLine.nextLine();

    //Searching for a star with the same name in the system using iterator. If a match is found, we delete it from the system.
    Iterator<Star> iterator = system.iterator();
    while(iterator.hasNext()) {
      Star star = iterator.next();
      if(star.getName() == starName) {
        iterator.remove();
      }
    }
  }

  public void createPlanet(Scanner inputLine) {
    System.out.println("Please enter the name of the planet");

    System.out.println("Please enter the average radius in km: ");
    System.out.println("Please enter the average orbit radius: ");

  }

}
