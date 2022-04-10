package cloneGraph;

import java.util.HashMap;
import java.util.LinkedList;

class Solution {
  public Node cloneGraph(Node node) {
    
    if (node == null) return null;
    
    HashMap<Node, Node> map = new HashMap<>();
    LinkedList<Node> queue = new LinkedList<>();
    
    map.put(node, new Node(node.val));
    queue.add(node);
    
    while(!queue.isEmpty()) {
      // get a node in the queue
      Node curr = queue.remove();
      // iterate through neighbors and add unseen
      for (Node n: curr.neighbors) {
        //add unseen
        if (!map.containsKey(n)) {
          map.put(n, new Node(n.val));
          queue.add(n);
        }
        // add edges for new node
        map.get(curr).neighbors.add(map.get(n));
      }
      
    }
    
    return map.get(node);
    
  }
}