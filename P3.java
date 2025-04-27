import java.io.*;
import java.util.*;

public class P3{
    int[] states = {0, 1, 2, 3};
    int startState = 0;
    int[] finalStates = {3};
    char[] alphabet = {'x', 'y', 'z'};

    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[]{1, 0, 0}),
        Map.entry(1, new int[]{1, 2, 0}),
        Map.entry(2, new int[]{1, 0, 3}),
        Map.entry(3, new int[]{3, 3, 3})
    );

    DFA dfa = new DFA(states, startState, finalStates, alphabet, transitionTable);

    public P3(List<String> testCases, BufferedWriter bw) {
        dfa.solveProblem(testCases, bw);
        System.out.println("Problem 3 done");
    }
}