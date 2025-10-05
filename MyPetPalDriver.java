package program;
import java.util.*;

/*
Title:          My Pet Pal
Team:           Object Grind
Programmers:    Diana Reyes, [PRIVATE NAME], [PRIVATE NAME],
Class:          Introduction to Information Systems 147
Section:        05
Date:           5/16/23
Description:

    This program is designed to assist pet owners and veterinarians in calculating
    the required calories and feeding schedule for dogs and cats. By providing information
    such as the pet's status (spayed/neutered), weight, and activity level (for dogs only),
    the program calculates the optimal caloric intake and generates a feeding schedule tailored
    to the specific needs of the pet.
    This program aims to promote the health and well-being of pets by ensuring they receive appropriate
    nutrition based on their individual characteristics.
 */

public class MyPetPalDriver {
    public static void main(String[] args) {
        // Greet the user and ask for input
        System.out.println("\nWelcome To My Pet Pal");
        System.out.println("Please Answer The Following Questions!");

        // Interface Organization
        System.out.println("--------------------------------------------------------");

        // Ask the user whether they have a cat or dog
        System.out.print("Do you have a cat or dog? ");
        Scanner input = new Scanner(System.in);
        String animal = input.nextLine().toLowerCase();

        // Determine which animal the user has inputted
        switch (animal) {
            case "dog" -> {
                // Call the dog method from the Dog class
                DogClass dog = new DogClass();
                dog.dogMethod();
            }
            case "cat" -> {
                // Call the cat method from the Cat class
                CatClass cat = new CatClass();
                cat.catMethod();
            }
            default ->
                // If the input is neither "cat" nor "dog", print an error message
                    System.out.println("Error: Invalid input.");
        }
    }
}