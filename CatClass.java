package petpal;
import java.util.Scanner;

public class CatClass {
    // Data Fields
    private String catStatus;
    private double catWeight;

    // Getters and Setters
    public String getCatStatus() {
        return catStatus;
    }

    public void setCatStatus(String catStatus) {
        this.catStatus = catStatus;
    }

    public double getCatWeight() {
        return catWeight;
    }

    public void setCatWeight(double catWeight) {
        this.catWeight = catWeight;
    }

    // Behaviors
    public void catMethod() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get and Set the cat's spayed/neutered status
            System.out.print("Is the cat spayed or neutered? (YES or NO): ");
            setCatStatus(scanner.nextLine().toLowerCase());

            double statusMultiplier;
            if (getCatStatus().equalsIgnoreCase("yes")) {
                statusMultiplier = 1.2;
            } else if (getCatStatus().equalsIgnoreCase("no")) {
                statusMultiplier = 1.4;
            } else {
                System.out.println("INVALID: Must be YES or NO");
                return;
            }

            // Get and Set the cat's weight
            System.out.print("What is the cat's weight (in lbs)? ");
            setCatWeight(scanner.nextDouble());

            if (getCatWeight() >= 30 || getCatWeight() <= 0) {
                System.out.println("INVALID: CAT WEIGHT MUST BE BETWEEN 0 AND 30 LBS.");
                return;
            }

            // Convert weight from pounds (lbs) to kilograms (kgs)
            double weightInKg = getCatWeight() / 2.2;

            // Calculate Resting Energy Requirement (RER)
            double rer = 70 * Math.pow(weightInKg, 0.75);

            // Calculate Maintenance Energy Requirement (MER)
            double mer = statusMultiplier * rer;

            // Round the MER to the nearest whole number and convert to an integer
            int roundedMer = (int) Math.ceil(mer);

            // Interface Organization and display mer
            System.out.println("--------------------------------------------------------");
            System.out.println("\nYour Cat Requires Around " + roundedMer + " Calories Per Day");
            System.out.println("\n--------------------------------------------------------");
            System.out.println("\nThank You For The Data!");
            System.out.println("Calculating The Feeding Schedule Now");
            System.out.println("\n--------------------------------------------------------");

            // Check if MER can be divided evenly into two portions
            // If it is not divisible by 2 evenly, add one and check again
            double feedingSchedule = mer / 2;
            if (feedingSchedule % 2 != 0) {
                while (roundedMer % 2 != 0) {
                    roundedMer++;
                }

                // Display Feeding Schedule
                int merPerFeeding = roundedMer / 2;
                System.out.println("\nFeeding schedule:\n ");
                System.out.println("Mornings = " + merPerFeeding + " calories");
                System.out.println("Afternoons = " + merPerFeeding + " calories");
            }
        }
    }
}
