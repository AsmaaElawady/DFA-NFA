import java.util.*;
import java.io.*;

public class P4 {

    int[] states = {0, 1,2,3,4,5,6};
    int startState = 0;
    int[] finalStates = {0};
    char[] alphabet = {'0', '1'};


    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[]{0, 1}),
        Map.entry(1, new int[]{2, 3}),
        Map.entry(2, new int[]{4, 5}),
        Map.entry(3, new int[]{6, 0}),
        Map.entry(4, new int[]{2, 1}),
        Map.entry(5, new int[]{3, 4}),
        Map.entry(6, new int[]{5, 6})
    );

    DFA p4Dfa = new DFA(states, startState, finalStates, alphabet, transitionTable);

    public P4(BufferedReader br, BufferedWriter bw) {
        p4Dfa.solveProblem(br, bw);
        System.out.println("Problem 4 done");
    }
    
}
