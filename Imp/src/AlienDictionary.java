/*
Leetcode 269: Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of
this new language. Derive the order of letters in this language.
input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

output:"wertf"

Using graph + Topological sort + BFS
runtime:O(V + E)
Space: O(max(V,E))
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static String alienOrder(String[] words){
        if(words == null || words.length == 0) return "";

        // 构建图：每一个char，都有一堆后续的char
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        // 统计入度
        int[] indegree = new int[26];

        // 两步走：第一步构建图+统计入度，第二步用BFS去更新
        buildGraph(words,graph,indegree);
        return bfs(graph,indegree);
    }

    // 第一步构建图+统计入度
    private static void buildGraph(String[] words, HashMap<Character, HashSet<Character>> graph, int[] indegree){
        // 为每一个char构建一个空图
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // 填图+统计入度
        for(int i = 1; i < words.length; i++){
            // 取出前后两个string作比较，first = "wrt",second = "wrf"，t在f前面，所以f是t的下一层邻居，f的indegree要增加
            String first = words[i - 1];
            String second = words[i];

            // 从first和second里取最小的长度
            int len = Math.min(first.length(), second.length());
            for(int j = 0; j < len; j++){
                // 取出相同index的char，first的char应该是hashmap里的key
                // second的char是hashmap里的value，也就是说value是key的下一层邻居
                char key = first.charAt(j);
                char value = second.charAt(j);
                // 不相等时候就能排出先后
                if(key != value){
                    if(!graph.get(key).contains(value)){
                        graph.get(key).add(value);
                        indegree[value - 'a']++;
                    }
                    // 完成 -- 已经有差异，不在往后比
                    break;
                }
            }
        }
    }

    //第二步用BFS去更新
    private static String bfs(HashMap<Character, HashSet<Character>> graph, int[] indegree){
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // BFS起步，遍历图，从入度为0的开始，更新sb
        for(char c : graph.keySet()){
            if(indegree[c - 'a'] == 0){
                q.offer(c);
                sb.append(c);
            }
        }

        // 更新queue，吐出来，放进去，入度，sb
        while(!q.isEmpty()){
            char c = q.poll();

            for(char nextC : graph.get(c)){
                indegree[nextC - 'a']--;
                if(indegree[nextC - 'a'] == 0){
                    q.offer(nextC);
                    sb.append(nextC);
                }
            }
        }

        // 判断是否graph里的每个char都已经处理过了
        return sb.length() == graph.size() ? sb.toString() : "";
    }

    public static void main(String args[]){
        String[] arr = new String[]{"abc","ab"}; //{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(arr));
    }
}
