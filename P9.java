import java.util.*;
import java.io.*;
public class P9 {

    int[] states = {0, 1, 2, 3};
    int startState[] = {0};
    int[] finalState = {0,3};
    char[] alphabet = {'E','0', '1'}; // Alphabet with 'E' for epsilon, 'a', and 'b'

    Map<Integer, int[][]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[][]{{1}, {0}, {-1}}),   // 0: E->-1, 0->0, 1->1
        Map.entry(1, new int[][]{{-1}, {-1}, {2}}),      // 1: E->-1, 0->-1, 1->2
        Map.entry(2, new int[][]{{3}, {3}, {2}}),    // 2: E->-1, 0->2, 1->3
        Map.entry(3, new int[][]{{1}, {-1}, {-1}})    // 3: E->-1, 0->-1, 1->4
    );
    NFA p9nfa = new NFA(states,startState,finalState,alphabet,transitionTable);
    public P9 (int pNum, List<String>testCase, BufferedWriter bw)
    {
        p9nfa.solveProblem( pNum,testCase,bw);
        System.out.println("Problem 9 done");
    }
}
