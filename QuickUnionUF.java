/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Murtaza Kazmi
 */
public class QuickUnionUF implements UF {
 private int[] id;
 
 QuickUnionUF(int N){
     id = new int[N];
     for(int i = 0; i < N; i++){
         id[i] = i;
     }
 }
    @Override
    public void union(int p, int q) {
        if(!connected(p,q)){
            id[(find(p))] = find(q);
        }
    }

    @Override
    public int find(int p) {
        while(p != id[p]) {p = id[p];}
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        int total = 0;
        boolean[] bool = new boolean[id.length];
        
        
        for(int z = 0; z < id.length; z++){
            int count = 0;
            for(int x = 0; x < id.length; x++){
            if(find(id[x]) == find(id[z]) && bool[x] == false) {
                count++;
                bool[x] = true;
            }
            }
            if(count > 0) total++;
        }
        
        return total; 
    }
     public int get(int k){
     return id[k];
 }
     public void display(){
         System.out.println("");
         for(int i = 0; i < id.length; i++){
             System.out.print(id[i] + " ");
         }
     }
    
}
