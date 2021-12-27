package test;



public class Trie {
	class TrieNode{
		boolean isWord;
		TrieNode[] children;
		
		TrieNode(){
			children=new TrieNode[26];
			isWord=false;
		}
	}
	TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	boolean insert(String str){
		TrieNode curr=root;
		for(int i=0;i<str.length();i++) {
			int index=str.charAt(i)-'a';
			if(curr.children[index]==null) {
				curr.children[index]=new TrieNode();
			}
			curr= curr.children[index];
		}
		curr.isWord=true;
		return false;
		}
	
	boolean search(String str) {
		TrieNode curr=root;
		for(int i=0;i<str.length();i++) {
			int index=str.charAt(i)-'a';
			if(curr.children[index]==null)return false;
			curr=curr.children[index];
			
		}
		return curr.isWord;
	}
	
	public boolean startsWith(String str) {
		TrieNode curr=root;
		for(int i=0;i<str.length();i++) {
			int index=str.charAt(i)-'a';
			if(curr.children[index]==null)return false;
			curr=curr.children[index];
		}
		return true;
	}
	public static void main(String[] args) {
		Trie trie=new Trie();
		trie.insert("she");
		trie.insert("shells");
		trie.insert("see");
		trie.insert("by");
		System.out.println(trie.search("she"));
		System.out.println(trie.startsWith("shels"));
		

	}

}
