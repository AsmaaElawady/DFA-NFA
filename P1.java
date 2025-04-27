import java.io.*;
import java.util.*;
public class P1 {
    int[] states = {0, 1};
    int startState = 0;
    int[] finalStates = {1};
    char[] alphabet = {'a', 'b'};

    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[]{1, 0}),
        Map.entry(1, new int[]{0, 1})
    );

    DFA dfa = new DFA(states, startState, finalStates, alphabet, transitionTable);

    public P1(List<String> testCases, BufferedWriter bw) {
        dfa.solveProblem(testCases, bw);
        System.out.println("Problem 1 done");
    }
}

