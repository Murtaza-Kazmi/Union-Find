/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

/**
 *
 * @author Murtaza Kazmi
 */

public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
 System.out.println("Enter the number of 'sites':");
 long startTime = 0;
 Scanner scan = new Scanner(System.in);
 int N = scan.nextInt();
 QuickFindUF uf = new QuickFindUF(N);
 System.out.println("Input pairs of integers:");
 for(int i = 0; i < N; i = i+2) {
 startTime = System.nanoTime();
 int p = scan.nextInt();
 int q = scan.nextInt();
 if (uf.connected(p, q)) continue;
 uf.union(p, q);
 System.out.println("   " + p + " " + q);
 System.out.println(uf.count() + " components");
 uf.display();
 }
 
 long endTime = System.nanoTime();
 long timeElapsed = endTime - startTime;
 System.out.println("Execution time in nanoseconds: " + timeElapsed);
 System.out.println("Execution time in milliseconds: " + timeElapsed/1000000.0);
    }
}
// 9 0 3 4 5 8 7 2 2 1 5 7 0 3 4 2
// WeightedQU time = 200700 ns. 
//QuickUnion time = 202500 ns.
//QuickFind time = 320800 ns.
    
