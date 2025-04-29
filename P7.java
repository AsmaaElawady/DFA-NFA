import java.io.BufferedWriter;
import java.util.List;
import java.util.Map;

public class P7 {
    int[] states = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int[] startState = {0};
    int[] finalState = {4, 5, 7, 8, 9, 10};
    char[] alphabet = {'E', '0', '1'}; 

    Map<Integer, int[][]> transitionTable = Map.ofEntries(
        Map.entry(0, new int[][]{{-1}, {1}, {2}}),     
        Map.entry(1, new int[][]{{-1}, {3}, {4}}),     
        Map.entry(2, new int[][]{{-1}, {5}, {6}}),     
        Map.entry(3, new int[][]{{-1}, {11}, {4}}),   
        Map.entry(4, new int[][]{{-1}, {7}, {8}}),   
        Map.entry(5, new int[][]{{-1}, {9}, {10}}),    
        Map.entry(6, new int[][]{{-1}, {5}, {11}}),    
        Map.entry(7, new int[][]{{-1}, {9}, {4}}),   
        Map.entry(8, new int[][]{{-1}, {7}, {11}}),  
        Map.entry(9, new int[][]{{-1}, {11}, {10}}),  
        Map.entry(10, new int[][]{{-1}, {5}, {8}}) ,
        Map.entry(11, new int[][]{{-1}, {11}, {11}})   // dead state
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public P7(int pNum, List<String> testCases, BufferedWriter bw) {
        nfa.solveProblem( pNum,testCases, bw);
        System.out.println("Problem 7 done");
    }
}
