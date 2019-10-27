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
public class WeightedQU implements UF{
private int[] id;
private int[] size;

 WeightedQU(int N){
     id = new int[N];
     for(int i = 0; i < N; i++){
         id[i] = i;
     }
     size = new int[N];
     for(int j = 0; j < N; j++){
         size[j] = 1;
     }
 }
 @Override
    public void union(int p, int q) {
        if(!connected(p,q)){
            if(size[find(p)] > size[find(q)]){
            id[(find(q))] = find(p);
            //change of root of lower cost
            size[find(p)] += size[find(q)];
            }
            //BAAD WALA OOPER JAEGA IN HIERARCHY (EQUAL CASE)
            else{
                id[find(p)] = find(q);
                size[find(q)] += size[find(p)];
            }
        }
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
    
    @Override
    public int find(int p) {
        //with compression (id set to that of grandparent)
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];}
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
//counts the number of components
    //algo: array of false booleans init, next loop around every element and if same root,
    //the array[index] = true;
    
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
