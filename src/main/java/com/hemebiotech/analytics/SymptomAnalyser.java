package main.java.com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

public interface SymptomAnalyser {

    public List<String> readTheSymptoms() throws IOException;

    public SortedMap<String, Integer> countTheSymptoms(List<String> symptoms);

    public void writeTheSymptoms(SortedMap<String, Integer> symptomOccurrences) throws IOException;
}
