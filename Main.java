/**
 * Created by Mirsiss on 2016-10-10.
 *
 * Graph generator for Algorithm problems
 * generates edge list of connected graph at file "graph"
 *  */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        File file = new File("graph");
        FileWriter out = new FileWriter(file);
        String output = new String();
        Random rand = new Random();

        //output += "1\n";

        System.out.print("# of vertices : ");
        int N = sc.nextInt();
        System.out.print("# of edges : ");
        int M = sc.nextInt();
        //output += N + " " + M + "\n";
        System.out.print("max weight (1 for unweighted): ");
        int W = sc.nextInt();

        if(M < N-1) {
            System.out.println("# of edges must be equal or bigger than # of vertices - 1");
            System.exit(1);
        }
        else if(W < 1) {
            System.out.println("max weight must be bigger than 0");
            System.exit(1);
        }

        for(int i=0; i < N; i++) {
            output += i + " ";

            while(true) {
                int v = rand.nextInt(N);
                if(v != i) {
                    output += v + " ";
                    break;
                }
            }

            if(W != 1)
                output +=  Integer.toString(rand.nextInt(W-1) + 1);
            output += "\n";
        }

        for(int i=0; i < M-N; i++) {
            int v1 = rand.nextInt(N);
            int v2;

            while(true) {
                v2 = rand.nextInt(N);
                if(v1 != v2 && !output.contains(v2 + " " + v1))
                    break;
            }
            output += v1 + " " + v2 + " " + (rand.nextInt(W-1) + 1) + "\n";
        }
        System.out.println(output);
        out.write(output);
        out.flush();
    } //end main()
} //end Main