import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class P10 {
    int[] states = {0, 1}; // 0: after x or start, 1: after y
    int[] startState = {0};
    int[] finalState = {0, 1}; // Accept if in state 0 or 1
    char[] alphabet = {'E', 'x', 'y'}; // Epsilon not used

    Map<Integer, int[][]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[][]{{-1}, {0}, {1}}), // from state 0
        Map.entry(1, new int[][]{{-1}, {0}, {-1}}) // from state 1
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    // public P10(BufferedReader br, BufferedWriter bw) {
    //     nfa.solveProblem(br, bw);
    // }

    public P10(BufferedReader br, BufferedWriter bw) {
        nfa.solveProblem(br, bw);
        System.out.println("Problem 10 done");

    }
}
