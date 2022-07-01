package wordLadder;
import javafx.util.Pair;
import java.util.*;

// TC and SC O(m^2 x n) where m is the WORDLENGTH and n is the length of wordList
// constructing and traversal is both m^2 x n because when constructing the graph
// loop in a loop will be mxn and constructing the substring is m
// same for the traversal.
// space is m^2 for the combination for the wildWords, and the adj list can be up to
// the length of the wordList in the worst case

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // construct graph. key is wildword MxN
        Map<String, List<String>> graph = new HashMap<>();
        int WORDLENGTH = beginWord.length();
        for (String w: wordList){
            for (int i=0; i < WORDLENGTH; i++) {
                String wildWord = w.substring(0,i) + "*" + w.substring(i+1,WORDLENGTH);
                List<String> newAdjList = graph.getOrDefault(graph.get(wildWord), new ArrayList<>());
                newAdjList.add(w);
                graph.put(wildWord, newAdjList);
            }
        }

        // find shortest path
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Map<String,Boolean> seen = new HashMap<>();

        queue.offer(new Pair(beginWord,1));
        seen.put(beginWord,true);

        while (!queue.isEmpty()){
            Pair<String,Integer> currNode = queue.poll();
            String currWord = currNode.getKey();
            int currLevel = currNode.getValue();

            //extract wildWords(keys) and search for endword
            for (int i=0; i<WORDLENGTH; i++){
                String wildWordKey = currWord.substring(0,i) + "*" + currWord.substring(i+1,WORDLENGTH);
                for (String w: graph.getOrDefault(wildWordKey, new ArrayList<>())){
                    if (w.equals(endWord)) return currLevel + 1;
                    queue.offer(new Pair(w, currLevel + 1));
                }
            }
        }
        return 0;
    }
}