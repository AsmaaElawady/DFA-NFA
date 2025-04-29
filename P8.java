import java.io.BufferedWriter;
import java.util.*;

public class P8
{
int[] states = {0, 1, 2, 3,4};
int startState[] = {0};
int[] finalState = {4};
char[] alphabet = {'E','a', 'b'}; // Alphabet with 'E' for epsilon, 'a', and 'b'

Map<Integer, int[][]> transitionTable = Map.ofEntries(
    Map.entry(0, new int[][]{{-1}, {0, 1}, {0}}),   
    Map.entry(1, new int[][]{{-1}, {-1}, {2}}),      
    Map.entry(2, new int[][]{{-1}, {2, 3}, {2}}),      
    Map.entry(3, new int[][]{{-1}, {-1}, {4}}),       
    Map.entry(4, new int[][]{{-1}, {4}, {4}})          
);

NFA nfa = new NFA(states,startState,finalState,alphabet,transitionTable);
public P8 (int pNum, List<String>testCase, BufferedWriter bw)
{
nfa.solveProblem( pNum,testCase,bw);
System.out.println("Problem 8 done");
}
}