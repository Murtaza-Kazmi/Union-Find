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
public class QuickFindUF implements UF{
 private int[] id;
 public QuickFindUF(int N) {
 //TODO
     id = new int[N];
     for(int i = 0; i < N; i++){

    id[i] = i;
}
 }

 @Override
 public int find(int p) {
 //TODO
 return id[p];
 }

 @Override
 public boolean connected(int p, int q) {
 //TODO
 return find(p) == find(q);
 }
public int count() {
        
        int total = 0;
        boolean[] bool = new boolean[id.length];
        
        
        for(int z = 0; z < id.length; z++){
            int ch = id[z];
            int count = 0;
            for(int x = 0; x < id.length; x++){
            if(id[x] == ch && bool[x] == false) {
                count++;
                bool[x] = true;
            }
            }
            if(count > 0) total++;
        }
        
        return total; 
    }


 @Override
 public void union(int p, int q) {
 //TODO
     if(!this.connected(p, q)){
    for(int i = 0; i < id.length; i++){
        if(i != p){
        if(find(i) == find(p)) {
            id[i] = find(q);
        }
        }
    }
    id[p] = find(q);
    }
     }
 public void display(){
         System.out.println("");
         for(int i = 0; i < id.length; i++){
             System.out.print(id[i] + " ");
         }
     }
 }