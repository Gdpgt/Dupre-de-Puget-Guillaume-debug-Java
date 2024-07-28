package main.java.com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

public class Main {

    public static void main (String[] args) {

		SymptomAnalyserImpl symptomAnalyser = new SymptomAnalyserImpl();

        try {
            List<String> symptoms = symptomAnalyser.readTheSymptoms();
            SortedMap<String, Integer> symptomOccurrences = symptomAnalyser.countTheSymptoms(symptoms);
            symptomAnalyser.writeTheSymptoms(symptomOccurrences);

        } catch (IOException e) {
            System.err.println("There was an error with the file : " + e.getMessage());
        }
    }
}









//My 1st version of the program, without separation of duties  :
// (scroll below to see the original code, that I corrected)
/*public class AnalyticsCounter {

	public static void main(String[] args) {

		SortedMap<String, Integer> symptomOccurrences = new TreeMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/symptoms.txt"))) {
			// Reads the 1st line (ending with a \n) of the file and places the cursor at the end of it
			String line = reader.readLine();

			while (line != null) {
				symptomOccurrences.merge(symptom, 1, Integer::sum);
				line = reader.readLine();
			}

		} catch (IOException e) {
			System.err.println("The file could not be found : " + e.getMessage());
		}

		LocalDate todayDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedTodayDateForFileName = todayDate.format(formatter);
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedTodayDateForFileContent = todayDate.format(formatter);

		try (FileWriter writer = new FileWriter("results/symptom_occurrences_"
				+ formattedTodayDateForFileName + ".txt")) {

			writer.write(formattedTodayDateForFileContent + "\n\nHere is the alphabetically sorted list of " +
					"encountered symptoms, and their number of occurrences :\n\n");
			for (SortedMap.Entry<String, Integer> symptomCount : symptomOccurrences.entrySet()) {
				String symptom = symptomCount.getKey();
				String capitalizedSymptom = Character.toUpperCase(symptom.charAt(0)) + symptom.substring(1);
				int count = symptomCount.getValue();
				writer.write(capitalizedSymptom + " : " + count + "\n");
			}

		} catch (IOException e) {
			System.err.println("There was a problem while editing the file symptom_occurrences_"
					+ formattedTodayDateForFileName + ".txt : " + e.getMessage());
		}
	}
}*/






//The original code, corrected
/*public class AnalyticsCounter {

	public static void main(String[] args) {
		SortedMap<String, Integer> symptomOccurrences = new TreeMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/symptoms.txt"))) {
			// Reads the 1st line (ending with a \n) of the file and places the cursor at the end of it
			String line = reader.readLine();

			int headacheCount = 0;
			int rashCount = 0;
			int constrictedPupilsCount = 0;
			while (line != null) {
				if (line.equals("headache")) {
					headacheCount++;
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					constrictedPupilsCount++;
				}
				line = reader.readLine();    // Reads another line
			}
			System.out.println("Number of headaches: " + headacheCount);
			System.out.println("Number of rashes: " + headacheCount);
			System.out.println("Number of constricted pupils: " + headacheCount);

			FileWriter writer = new FileWriter("results/TO_DELETE_symptom_occurrences.txt");
			writer.write("Number of headaches: " + headacheCount + "\n");
			writer.write("Number of rashes: " + rashCount + "\n");
			writer.write("Number of constricted pupils: " + constrictedPupilsCount + "\n");
			writer.close();

		} catch (IOException e) {
			System.err.println("An error was found : " + e.getMessage());
		}
	}
}*/
