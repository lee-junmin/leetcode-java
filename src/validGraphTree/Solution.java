package validGraphTree;

import java.util.*;

public class Solution {
  // where V is the n and E is the number of elements in edges
  // TC O(V + E) because we recurse for every edge
  // SC O(V + E) because we need space to store the graph, recursion calls also take this much
  public boolean validTree(int n, int[][] edges) {
    // 1. make an adj list and a boolean array to mark the visted nodes
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for (int i=0; i<n; i++) { // TC O(V) SC O(V)
      graph.add(new ArrayList<Integer>());
    }
    for (int[] pair: edges){ // TC O(E) SC O(E)
      graph.get(pair[0]).add(pair[1]);
      graph.get(pair[1]).add(pair[0]);
    }
    // 2. call the dfs on a starting node
    if (!dfs(0, -1, visited, graph)){ // TC O(E) SC O(E)
      return false;
    }
    // 6. after the recursion, if all the nodes are visited return true
    for(boolean f: visited){  // TC O(V)
      if (!f) return false;
    }
    return true;
    
  }
  // 3. goal is to visit all the nodes without meeting a node that is marked visited
  private boolean dfs(int curr, int parent, boolean[] visited, List<List<Integer>> graph){
    // 4. if we meet a visited return false
    if (visited[curr]) return false;
    // 5. otherwise process the current node by marking and call recursion at each adjacent node
    // which is not the parent, when a function returns false, pass that return to the return of this call
    visited[curr] = true;
    for (int adj: graph.get(curr)){
      if (adj != parent && !dfs(adj, curr, visited, graph)) {
        return false;
      }
    }
    
    return true;
  }
  
  
  public boolean validTree_bfs(int n, int[][] edges) {
    
    if (edges.length == 0){
      if (n == 1) return true;
      return false;
    }
    
    List<List<Integer>> graph = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    
    for (int i=0; i<n; i++){
      graph.add(new ArrayList<Integer>());
    }
    
    for (int[] pair: edges){
      graph.get(pair[0]).add(pair[1]);
      graph.get(pair[1]).add(pair[0]);
    }
    
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(edges[0][0]);
    
    while(!queue.isEmpty()){
      for(int i=0; i<queue.size(); i++){
        int curr = queue.poll();
        if (seen.contains(curr)) return false;
        seen.add(curr);
        for (int adj: graph.get(curr)){
          if (!seen.contains(adj)) queue.offer(adj);
        }
      }
    }
    return seen.size() == n;
  }
  //
  
  
  
}
