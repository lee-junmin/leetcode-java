import java.util.LinkedList;
import java.util.HashMap;

// TC O(e log e/v) the dominate component is the sorting
// SC O(v + e) where v is the number of airports and e is the length of tickets
// 

class Solution {
    
    HashMap<String, PriorityQueue> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {    

        for (List<String> ticket: tickets){            
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<String>());
            graph.get(from).add(to);
        }
        dfs("JFK");
        return result;        
    }
    
    private void dfs(String key){
        PriorityQueue<String> adj = graph.get(key);
        while (adj != null && adj.size() != 0){
            dfs(adj.poll());
        }
        
        result.addFirst(key);
    }
}