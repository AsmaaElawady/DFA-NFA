import java.io.BufferedWriter;
import java.util.*;
import java.io.IOException;
public class NFA {
    private int[] states; // States of the NFA
    private int[] startState; // Start states
    private int[] finalState; // Final states
    private char[] alphabet; // Alphabet symbols
    private Map<Integer, int[][]> transitionTable; // Transition table for the NFA

    // Constructor to initialize the NFA
    public NFA(int[] states, int[] startState, int[] finalState, char[] alphabet,
               Map<Integer, int[][]> transitionTable) {
        this.states = states;
        this.startState = startState;
        this.finalState = finalState;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }

    // Method to check if the input string is accepted by the NFA
    public boolean isAccepted(String input) {
        // We will use a set to track the current possible states
        Set<Integer> currentStates = new HashSet<>();

        // Add the start state(s) to the current states
        for (int start : startState) {
            currentStates.add(start);
        }

        // Handle epsilon transitions before processing input
        handleEpsilonTransitions(currentStates);

        // Process each character of the input string
        for (char c : input.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();

            // Find the index of the character in the alphabet
            int alphabetIndex = getAlphabetIndex(c);
            if (alphabetIndex == -1) {
                return false; // If the character is not in the alphabet
            }

            // For each current state, find the next states based on the input character
            for (int state : currentStates) {
                int[][] transitions = transitionTable.get(state);
                if (transitions != null && transitions[alphabetIndex] != null) {
                    for (int nextState : transitions[alphabetIndex]) {
                        if (nextState != -1) {
                            nextStates.add(nextState); // Add valid transitions
                        }
                    }
                }
            }

            // Update the current states to the next states
            currentStates = nextStates;

            // Handle epsilon transitions after consuming a symbol
            handleEpsilonTransitions(currentStates);
        }

        // Check if any of the current states is a final state
        for (int state : currentStates) {
            for (int finalState : this.finalState) {
                if (state == finalState) {
                    return true;
                }
            }
        }

        // No final state was reached
        return false;
    }

    // Helper method to handle epsilon transitions
    private void handleEpsilonTransitions(Set<Integer> currentStates) {
        Set<Integer> epsilonClosure = new HashSet<>(currentStates);

        // Keep adding states reachable via epsilon transitions
        boolean updated;
        do {
            updated = false;
            Set<Integer> newStates = new HashSet<>(epsilonClosure);

            // Check for epsilon transitions for each state in currentStates
            for (int state : epsilonClosure) {
                int[][] transitions = transitionTable.get(state);
                if (transitions != null && transitions[0] != null) { // Epsilon transition is at index 0
                    for (int nextState : transitions[0]) {
                        if (nextState != -1 && !newStates.contains(nextState)) {
                            newStates.add(nextState);
                            updated = true;
                        }
                    }
                }
            }

            epsilonClosure = newStates;
        } while (updated);

        currentStates.clear();
        currentStates.addAll(epsilonClosure);
    }

    // Helper method to get the index of a character in the alphabet
    private int getAlphabetIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        return -1; // Return -1 if the character is not in the alphabet
    }

    public void solveProblem(int pNum,List<String> testCases, BufferedWriter bw) {
        try {
            bw.write(Integer.toString(pNum));
            bw.newLine();
            for (String testCase : testCases) {
                boolean result = isAccepted(testCase);
                bw.write(result ? "True" : "False");
                bw.newLine();
            }
            bw.write("x");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
