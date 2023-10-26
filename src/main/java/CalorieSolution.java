
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalorieSolution {
    public static void main(String[] args) {
        String inputFile = "calorie.txt";

        int maxCalories = 0;
        int currentCalories = 0;


        try  {
            FileReader fileReader = new FileReader(inputFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) {
                    if (currentCalories > maxCalories) {
                        maxCalories = currentCalories;
                    }
                    currentCalories = 0;
                } else {
                    int calories = Integer.parseInt(line);
                    currentCalories += calories;
                }
            }

            if (currentCalories > maxCalories) {
                maxCalories = currentCalories;
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        System.out.println("The Elf carrying the most Calories is carrying a total of " + maxCalories + " Calories.");
    }
}
