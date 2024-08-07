# Symptom Analysis Program

This Java program is designed to analyze symptoms from a file, count their occurrences, and write the results to a new file. The program consists of three main components: the main class `Main`, an interface `SymptomAnalyser`, and an implementation of this interface `SymptomAnalyserImpl`.

It is designed to process data from a file named `symptoms.txt` located in the `src/resources` directory and outputs the results in a timestamped file in the `results` directory.

## Getting Started

### Prerequisites

- JDK 17 installed
- An IDE or text editor for Java development
- Basic understanding of Java programming

### Installing

1. Clone the repository or download the source code.
2. Ensure the `symptoms.txt` file is placed in the `src/resources` directory.

### Compiling and Running

Compile the Java files:

```sh
javac Main.java SymptomAnalyser.java SymptomAnalyserImpl.java
```

Run the program:

```sh
java Main
```

## Usage

1. Place the symptoms data in the `src/resources/symptoms.txt` file.
2. Run the `Main` class.
3. The program will read the symptoms, count their occurrences, and output the results to a file in the `results` directory with a timestamped filename.

## Class Descriptions

### Main

The `Main` class serves as the entry point of the program. It creates an instance of `SymptomAnalyserImpl` and orchestrates the reading, counting, and writing of symptoms.


### SymptomAnalyser

The `SymptomAnalyser` interface defines three methods for reading, counting, and writing symptoms.


### SymptomAnalyserImpl

The `SymptomAnalyserImpl` class implements the `SymptomAnalyser` interface. It provides concrete methods for reading symptoms from a file, counting their occurrences, and writing the results to a new file.

