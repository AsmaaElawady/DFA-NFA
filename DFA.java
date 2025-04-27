import java.io.*;
import java.util.*;

public class DFA {
    private final int[] states;
    private final int startState;
    private final Set<Integer> finalStates;
    private final char[] alphabet;
    private final Map<Integer, int[]> transitionTable;
    private final Map<Character, Integer> symbolIndexMap;

    public DFA(int[] states, int startState, int[] finalStates, char[] alphabet, Map<Integer, int[]> transitionTable) {
        this.states = states;
        this.startState = startState;
        this.finalStates = new HashSet<>();
        for (int fs : finalStates) this.finalStates.add(fs);
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;

        // Map symbol to index in the transition array
        this.symbolIndexMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            symbolIndexMap.put(alphabet[i], i);
        }
    }

    public boolean isAccepted(String s) {
        int currentState = startState;
        for (char c : s.toCharArray()) {
            if (!symbolIndexMap.containsKey(c)) return false; // Invalid symbol
            int symbolIndex = symbolIndexMap.get(c);
            currentState = transitionTable.get(currentState)[symbolIndex];
        }
        return finalStates.contains(currentState);
    }

    public void solveProblem(List<String> testCases, BufferedWriter bw) {
        try {
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

