import java.util.*;

class AutocompleteSystem4 {

    class Trie{

        boolean isWord;
        Trie[] childs;

        public Trie(){
            this.childs = new Trie[27];
            this.isWord = false;
        }
        public int c2i(char c) {return c == ' '? 0 : c - 'a' + 1;}
        public char i2c(int i) {return i == 0 ? ' ' : (char)('a' + i - 1);}


        void add(String s){
            Trie p = this;
            for (int i = 0; i < s.length();  i++){
                char c = s.charAt(i);
                int index = c2i(c);
                if (p.childs[index] == null) p.childs[index] = new Trie();
                p = p.childs[index];
            }
            p.isWord = true;
        }

        List<String> search(Trie p, StringBuilder buffer){
            List<String> res = new ArrayList<String>();
            if (p == null) return res;
            getSuffix(res, p, buffer);
            return res;
        }

        private void getSuffix(List<String> res, Trie p, StringBuilder buffer){
            if (p.isWord) {
                res.add(buffer.toString());
                for (int i = res.size()-1 ; i >= 1; i--){
                    if (freq.get(res.get(i)) > freq.get(res.get(i-1)))  Collections.swap(res, i, i-1);
                    else break;
                }
                while(res.size() > 3) res.remove(res.size()-1);
            }
            for (int i = 0 ; i < p.childs.length; i++){
                if (p.childs[i] != null) {
                    char c = i2c(i);
                    buffer.append(c);
                    getSuffix(res, p.childs[i], buffer);
                    if (buffer.length() > 0 ) buffer.setLength(buffer.length()-1);
                }
            }
        }
    }

    Trie trie, last;
    Map<String, Integer> freq;
    StringBuilder buffer;

    public AutocompleteSystem4(String[] sentences, int[] times) {
        this.trie =  new Trie();
        this.last = trie;
        this.freq = new HashMap<>();
        this.buffer = new StringBuilder();

        for (int i = 0 ; i < sentences.length ; i++){
            trie.add(sentences[i]);
            freq.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#'){
            String word = buffer.toString();
            if (! freq.containsKey(word)) freq.put(word, 0);
            freq.put(word, freq.get(word) + 1);
            trie.add(word);
            buffer.setLength(0);
            this.last = trie;
            return new ArrayList<String>();
        }
        buffer.append(c);
        int index = trie.c2i(c);
        last = last == null ? null : last.childs[index];
        return trie.search(last, buffer);
    }
}


