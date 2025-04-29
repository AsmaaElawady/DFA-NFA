import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class P6
{
    int[] states = {0, 1, 2, 3};
    int[] startState = {0};
    int[] finalState = {1};
    char[] alphabet = {'E', 'a', 'b'};

    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
        entry(0, new int[][]{null, new int[]{2}, new int[]{1}}),
        entry(1, new int[][]{null, new int[]{3}, new int[]{0}}),
        entry(2, new int[][]{null, new int[]{0}, new int[]{3}}),
        entry(3, new int[][]{null, new int[]{1}, new int[]{2}})
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    // public P6(BufferedReader br, BufferedWriter bw) {
    //     nfa.solveProblem(br, bw);
    // }
    public P6(int pNum, List<String> testCases, BufferedWriter bw) {
        nfa.solveProblem(pNum,testCases, bw);
        System.out.println("Problem 6 done");

    }
}
