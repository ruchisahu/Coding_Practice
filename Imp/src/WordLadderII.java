import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList == null || wordList.size() == 0) return res;

        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return res;

        HashMap<String,List<String>> graph = new HashMap<>();

        // 用set去记录当前一层的字符，避免重复
        HashSet<String> curLevel = new HashSet<>();
        curLevel.add(beginWord);

        boolean isEnd = false;

        // BFS建立graph
        while(!curLevel.isEmpty() && !isEnd){
            // this is important for minimizing the graph size, and avoid backtrack of the path
            // 删掉parent层的字符，因为下面的操作是查看children的，避免重复
            wordSet.removeAll(curLevel);
            HashSet<String> nextLevel = new HashSet<>();

            for(String word : curLevel){
                graph.put(word, new ArrayList<>());

                StringBuilder sb = new StringBuilder(word);
                for(int i = 0; i < word.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == word.charAt(i)) continue;

                        sb.setCharAt(i,c);
                        if(!wordSet.contains(sb.toString())) continue;
                        graph.get(word).add(sb.toString());
                        nextLevel.add(sb.toString());

                        if(sb.toString().equals(endWord)){
                            isEnd = true;
                        }
                    }
                    sb.setCharAt(i,word.charAt(i));
                }
            }
            curLevel = nextLevel;
        }

        if(!isEnd) return res;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        // 用DFS去遍历已经建立好的graph，找到路径
        getPathDFS(graph,res,list,beginWord,endWord);
        return res;
    }

    public static void getPathDFS(HashMap<String,List<String>> graph, List<List<String>> res, List<String> list, String begin, String end){
        if(begin.equals(end)){
            res.add(new ArrayList<>(list));
            return;
        }

        if(!graph.containsKey(begin)) return;

        for(String next : graph.get(begin)){
            list.add(next);
            getPathDFS(graph, res, list, next, end);
            list.remove(list.size()-1);
        }
    }

    public static void main(String args[]){
        String beginWord = "hit", endWord = "cog";

        List<String> wordList = new ArrayList<>();
        String[] arr = new String[]{"hot","dot","dog","lot","log","cog"};
        for(String s : arr){
            wordList.add(s);
        }

        System.out.println(findLadders(beginWord,endWord,wordList));
    }
}
