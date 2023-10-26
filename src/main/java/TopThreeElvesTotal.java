import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopThreeElvesTotal {
    public static void main(String[] args) {
        String inputFile = "calorie.txt";

        List<Integer> caloriesList = new ArrayList<>();
        int currentCalories = 0;

        try  {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    caloriesList.add(currentCalories);
                    currentCalories = 0;
                } else {
                    int cal = Integer.parseInt(line);
                    currentCalories += cal;
                }
            }

            caloriesList.add(currentCalories);

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        Collections.sort(caloriesList, Collections.reverseOrder());

        int topThreeTotal = 0;

        for (int i = 0; i < Math.min(3, caloriesList.size()); i++) {
            topThreeTotal += caloriesList.get(i);
        }

        System.out.println("The top three Elves are carrying a total of " + topThreeTotal + " Calories.");
    }
}

