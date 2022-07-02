package courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
// DFS approach
// where V is the numCourses and E is the length of the prerequisites
// TC O(V+E) SC O(V+E)
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // 1. make adjList and status array that flags 0:not visited 1: visited 2: cleared
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //
    int[] status = new int[numCourses];
    for (int i=0; i<numCourses; i++){ // TC O(V+E) SC O(V+E) populate nodes and edges in adj list
      graph.add(new ArrayList<Integer>());
    }
    for (int[] pair: prerequisites){
      graph.get(pair[0]).add(pair[1]);
    }
    
    // 2. call dfs for each node of the graph (because of possibly not connected nodes)
    for (int i=0; i<numCourses; i++) { // recursion TC O(V+E) SC O(V+E)
      if(!dfs(i, status, graph)) return false;
    }
    return true;
  }
  
  
  private boolean dfs(int node, int[] status, ArrayList<ArrayList<Integer>> graph){
    // 3. return true of already cleared
    if (status[node] == 2) return true;
    // 7. but when we are dfs through the graph,
    // if we meet a node that was visited but not cleared
    // that means there is a cycle, return false
    if (status[node] == 1) return false;
    
    // 4. open case
    status[node] = 1; // opened the case
    
    // 5. call dfs on each adjacent node
    for(int adj: graph.get(node)) {
      if (!dfs(adj, status, graph)) return false;
    }
    
    // 6. if we went through all the recursion stuff with no problem, set node to cleared
    //and return true for that node
    status[node] = 2;
    return true;
  }
  
  
  
  

  public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // adj list
    int[] indegree = new int[numCourses]; // indegree array - 0
    int count = 0;
    
    for (int i=0; i<numCourses; i++){
      graph.add(new ArrayList<Integer>());
    }
    //populate adj list
    for (int[] pair: prerequisites){
      graph.get(pair[0]).add(pair[1]);
      indegree[pair[1]]++; // populate the indegree array
    }
    
    Queue<Integer> queue = new LinkedList<>();
    
    for(int i=0; i<numCourses; i++){    // add node with no indegrees
      if (indegree[i] == 0) queue.offer(i);
    }
    
    while (!queue.isEmpty()){
      int curr = queue.poll();
      for (int i: graph.get(curr)){
        indegree[i]--;
        if (indegree[i] == 0) queue.offer(i);
      }
      
      count += 1;     // increase count
    }
    
    
    return count == numCourses;
  }
  
}