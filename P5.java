import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.Map;

public class P5 {
    int[] states = {0, 1, 2, 3};
    int startState = 0;
    int[] finalStates = {2};
    char[] alphabet = {'a', 'b'};

    public Map<Integer, int[]> transitionTable = Map.ofEntries(
    Map.entry(0, new int[]{1, 0}),   // 0: a->1, b->0
    Map.entry(1, new int[]{2, 3}),   // 1: a->2, b->3
    Map.entry(2, new int[]{1, 2}),   // 2: a->1, b->2
    Map.entry(3, new int[]{3, 3})    // 3: a->3, b->3 (trap state)
);
    DFA dfa = new DFA(states, startState, finalStates, alphabet, transitionTable);

    public P5(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
        System.out.println("Problem 5 done");
    }
}
