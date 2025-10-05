package program;
import java.util.Scanner;

public class  DogClass {
    // Data Fields
    private String dogStatus;
    private double dogWeight;
    private int dogActivityLevel;

    // Getters and Setters
    public String getDogStatus() {
        return dogStatus;
    }

    public void setDogStatus(String dogStatus) {
        this.dogStatus = dogStatus;
    }

    public double getDogWeight() {
        return dogWeight;
    }

    public void setDogWeight(double dogWeight) {
        this.dogWeight = dogWeight;
    }

    public int getDogActivityLevel() {
        return dogActivityLevel;
    }

    public void setDogActivityLevel(int dogActivityLevel) {
        this.dogActivityLevel = dogActivityLevel;
    }

    // Behaviors
    public void dogMethod() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get and Set the dog's spayed/neutered status
            System.out.print("Is the dog spayed or neutered? (YES or NO): ");
            setDogStatus(scanner.nextLine().toLowerCase());

            double statusMultiplier;
            if (getDogStatus().equalsIgnoreCase("yes")) {
                statusMultiplier = 1.6;
            } else if (getDogStatus().equalsIgnoreCase("no")) {
                statusMultiplier = 1.8;
            } else {
                System.out.println("INVALID: Must be YES or NO");
                return;
            }

            // Get and Set the dog's weight
            System.out.print("What is the dog's weight? (in lbs): ");
            setDogWeight(scanner.nextDouble());

            if (getDogWeight() >= 200 || getDogWeight() <= 0) {
                System.out.println("INVALID: Dog cannot be that weight.");
                return;
            }

            // Get and Set the dog's activity level
            System.out.print("On a scale of 1-4, how active is the dog?: ");
            setDogActivityLevel(scanner.nextInt());

            double activity;
            switch (getDogActivityLevel()) {
                case 1 -> activity = 1.3;
                case 2 -> activity = 2.0;
                case 3 -> activity = 3.0;
                case 4 -> activity = 4.5;
                default -> {
                    System.out.println("INVALID: Must be a value between 1 and 4");
                    return;
                }
            }

            // Convert weight from pounds (lbs) to kilograms (kgs)
            double weightConversion = getDogWeight() / 2.2;

            // Calculate Resting Energy Requirement (RER)
            double rer = 70 * Math.pow(weightConversion, 0.75);

            // Calculate Maintenance Energy Requirement (MER)
            double mer = rer * statusMultiplier * activity;

            // Round the MER to the nearest whole number and convert to an integer
            int roundedMer = (int) Math.ceil(mer);

            // Interface Organization and display mer
            System.out.println("--------------------------------------------------------\n");
            System.out.println("Your dog requires around " + roundedMer + " calories per day");
            System.out.println("\n--------------------------------------------------------");
            System.out.println("\nThank you for the data!");
            System.out.println("Calculating the feeding schedule now");
            System.out.println("\n--------------------------------------------------------");

            // Check if MER can be divided evenly into three portions
            // If it is not divisible by 3 evenly, add one and check again
            if (getDogActivityLevel() >= 3) {
                while (roundedMer % 3 != 0) {
                    roundedMer++;
                }

                // Display Feeding Schedule
                int merFinal = roundedMer / 3;
                System.out.println("\nFeeding Schedule:\n");
                System.out.println("Mornings = " + merFinal + " Calories");
                System.out.println("Afternoons = " + merFinal + " Calories");
                System.out.println("Evenings = " + merFinal + " Calories");
            }

            // Check if MER can be divided evenly into two portions
            // If it is not divisible by 2 evenly, add one and check again
            if (getDogActivityLevel() <= 2) {
                while (roundedMer % 2 != 0) {
                    roundedMer++;
                }

                // Display Feeding Schedule
                int merFinal = roundedMer / 2;
                System.out.println("\nFeeding Schedule: ");
                System.out.println("Mornings = " + merFinal + " Calories");
                System.out.println("Afternoons = " + merFinal + " Calories");
            }
        }
    }
}
