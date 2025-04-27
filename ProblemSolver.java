import java.util.*;
import java.io.*;

public class ProblemSolver {
    public static void main(String[] args) throws IOException {
        String inputFile = "input.txt";
        clearOutputFile("output.txt");  // Clear the output file before processing
        processFile(inputFile);  // Process the input file
    }

    public static void processFile(String inputFile) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            String line;
            int currProblem = -1;
            List<String> tests = new ArrayList<>();
            boolean readingTestCases = false; // Flag to track if we are reading test cases

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Handle "end" line (indicates end of problem's test cases)
                if (line.equalsIgnoreCase("end")) {
                    if (currProblem != -1) {
                        callProblemFunction(currProblem, tests, bw);  // Call the function for the current problem
                    }
                    currProblem = -1;  // Reset after processing
                    tests.clear();  // Clear test cases after processing
                    readingTestCases = false; // Reset flag
                    continue;  // Move to next line
                }

                // Handle Problem Number Detection
                if (line.matches("\\d+") && !readingTestCases) {
                    // Only treat as a problem number if we aren't already reading test cases
                    currProblem = Integer.parseInt(line);  // Set current problem number
                    readingTestCases = true; // Now we expect to read test cases for this problem
                } else {
                    // Treat as test case (either string or number)
                    tests.add(line);  // Add the test case to the list for the current problem
                }
            }
        }
    }

    // This method will now print the problem number and its test cases to the output file
    public static void callProblemFunction(int problemNumber, List<String> tests, BufferedWriter bw) throws IOException {
        // Print the problem number and its test cases to the output file
        // bw.write("Problem " + problemNumber + ":\n");
        // for (String testCase : tests) {
        //     bw.write(testCase + "\n");
        // }
        // bw.write("\n");

        // Call the corresponding problem class (implementations like P1, P2, etc.)
        switch (problemNumber) {
            case 1:
                P1 p1 = new P1(tests, bw);
                break;
            case 2:
                P2 p2 = new P2(tests, bw);
                break;
            case 3:
                P3 p3 = new P3(tests, bw);
                break;
            case 4:
                //P4 p4 = new P4(tests, bw);
                break;  
            case 5: 
                P5 p5 = new P5(tests, bw);
                break;
            case 6: 
                P6 p6 = new P6(tests, bw);
                break;
            case 7: 
                //P7 p7 = new P7(tests, bw);
                break;
            case 8: 
                P8 p8 = new P8(tests, bw);
                break;
            case 10:
                P10 p10 = new P10(tests, bw);
                break;
            default:
                System.out.println("Invalid problem number: " + problemNumber);
        }
    }

    // Clear the output file by overwriting it with an empty file
    public static void clearOutputFile(String outputFile) throws IOException {
        try (PrintWriter bw = new PrintWriter(new FileWriter(outputFile, false))) {
            // File is cleared (overwritten with empty content)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
