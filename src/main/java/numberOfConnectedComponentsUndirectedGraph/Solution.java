package numberOfConnectedComponentsUndirectedGraph;

import java.util.*;

public class Solution {
  
  public int countComponents(int n, int[][] edges) {
    int[] parent = new int[n];
    int[] rank = new int[n];
    int count = n;
    
    for (int i=0; i<n; i++){ // TC O(V) SC O(V) where V is n
      parent[i] = i;
      rank[i] = 1; // union by rank, add to larger
    }
    
    for (int[] pair: edges){ // TC O(E* a(N))
      count -= union(pair[0], pair[1], parent, rank);
    }
    return count;
  }
  
  private int find(int x, int[] parent){//rec, compressing the path
    if (parent[x] == x) return x; //base
    parent[x] = find(parent[x],parent);
    return parent[x];
  }
  
  private int union(int x, int y, int[] parent, int[] rank){
    // same parent return 0
    int parX = find(x, parent);
    int parY = find(y, parent);
    if (parX == parY) {
      return 0;
    } else {
      
      if (rank[parX] > rank[parY]) {
        parent[parY] = parX;
      } else if (rank[parY] > rank[parX]){
        parent[parX] = parY;
      } else {
        parent[parX] = parY;
        rank[parX]++;
      }
      
      return 1;
    }
    // different parent return 1
    
  }
  
  
  // DFS approach
  // where V is n, and E is the length of edges array
  // TC O(V+E) function calls
  // SC O(V+E)
  public int countComponents_dfs(int n, int[][] edges) {
    
    List<List<Integer>> graph = new ArrayList<>();
    Set<Integer> seen = new HashSet<>(); // SC O(V)
    int count = 0;
    
    for (int i=0; i<n; i++){  // build adjacency list TC O(E) SC O(E)
      graph.add(new ArrayList<>());
    }
    
    for (int[] pair: edges){
      graph.get(pair[0]).add(pair[1]);
      graph.get(pair[1]).add(pair[0]);
    }
    
    for (int i=0; i<n; i++){  // runtime stack TC O(E+V) SC O(V). we check each vertex in hashset, then call on  edges
      if (!seen.contains(i)) count++;
      dfs(i, graph, seen);
    }
    
    return count;
  }
  
  private void dfs(int curr,  List<List<Integer>> graph, Set<Integer> seen) {
    if (seen.contains(curr)) {
      return;
    }
  
    seen.add(curr);
  
    for (int adj : graph.get(curr)) {
      dfs(adj, graph, seen);
    }
  
  }
    public int countComponents_bfs(int n, int[][] edges) {
      List<List<Integer>> graph = new ArrayList<>();
      Set<Integer> seen = new HashSet<>();
      Queue<Integer> queue = new LinkedList<>();
      int count = 0;
    
      for(int i=0; i<n; i++){
        graph.add(new ArrayList<>());
      }
    
      for(int[] pair: edges){
        graph.get(pair[0]).add(pair[1]);
        graph.get(pair[1]).add(pair[0]);
      }
    
      for(int i=0; i<n; i++){
        if (!seen.contains(i)){
          queue.offer(i);
          while(!queue.isEmpty()){
            for(int j=0; j<queue.size(); j++){
              int curr = queue.poll();
              seen.add(curr);
              for(int adj: graph.get(curr)){
                if(!seen.contains(adj)) queue.offer(adj);
              }
            }
          }
          count++;
        }
      }
    
      return count;
    }
    
  }
  
  
  
  
