import java.util.*;
import java.io.*;

public class ProblemSolver {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
    
            new P1(br, bw);
            new P2(br, bw);
            new P3(br, bw);
            new P4(br, bw);
            new P5(br, bw);
            new P6(br, bw);
            new P7(br, bw);
            new P8(br, bw);
            new P9(br, bw);
            new P10(br, bw);
    
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
