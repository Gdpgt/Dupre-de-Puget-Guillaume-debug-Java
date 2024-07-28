package main.java.com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class SymptomAnalyserImpl implements SymptomAnalyser {

    @Override
    public List<String> readTheSymptoms() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/symptoms.txt"))) {

            String line = reader.readLine();
            List<String> symptoms = new ArrayList<>();
            while (line != null) {
                symptoms.add(line);
                line = reader.readLine();
            }
            return symptoms;
        }
    }

    @Override
    public SortedMap<String, Integer> countTheSymptoms(List<String> symptoms) {

        SortedMap<String, Integer> symptomOccurrences = new TreeMap<>();

        for (String symptom : symptoms) {
            symptomOccurrences.merge(symptom, 1, Integer::sum);
        }
        return symptomOccurrences;
    }

    @Override
    public void writeTheSymptoms(SortedMap<String, Integer> symptomOccurrences) throws IOException {

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
                String capitalizedSymptom = symptom.substring(0, 1).toUpperCase() + symptom.substring(1);
                int count = symptomCount.getValue();
                writer.write(capitalizedSymptom + " : " + count + "\n");
            }
        }
    }
}