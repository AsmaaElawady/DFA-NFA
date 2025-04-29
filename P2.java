import java.io.*;
import java.util.*;
public class P2 {
    int[] states = {0, 1, 2, 3, 4};
    int startState = 0;
    int[] finalStates = {3};
    char[] alphabet = {'0', '1'};

    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[]{4, 1}),
        Map.entry(1, new int[]{2, 2}),
        Map.entry(2, new int[]{3, 3}),
        Map.entry(3, new int[]{3, 3}),
        Map.entry(4, new int[]{4, 4})
    );

    DFA dfa = new DFA(states, startState, finalStates, alphabet, transitionTable);

    public P2(int pNum,List<String> testcases, BufferedWriter bw) {
        dfa.solveProblem(pNum,testcases, bw);
        System.out.println("Problem 2 done");
    }
}

