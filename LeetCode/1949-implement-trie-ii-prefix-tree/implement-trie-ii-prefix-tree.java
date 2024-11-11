class TrieNode{
    public int countWord;
    public int countPrefix;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

class Trie {

    TrieNode root;

    public Trie() {
        root  = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
            curr.countPrefix++;
        }
        curr.countWord++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if(curr.children[ch-'a'] == null) return 0;
            else curr = curr.children[ch-'a'];
        }
        return curr.countWord;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for (char ch: prefix.toCharArray()) {
            if(curr.children[ch-'a'] == null) return 0;
            else curr = curr.children[ch-'a'];
        }
        return curr.countPrefix;
    }
    
    public void erase(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if(curr.children[ch-'a'] == null) return;
            else curr = curr.children[ch-'a'];
            curr.countPrefix--;
        }
        curr.countWord--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */