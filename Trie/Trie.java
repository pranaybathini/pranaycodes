class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.setNode(ch,new TrieNode());
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                node = node.getNode(ch);
            }else{
                return null;
            }
        }
        return node;
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }
}

class TrieNode{
    private TrieNode[] links;
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[26];
    }
    
    public TrieNode getNode(char ch){
        return links[ch-'a'];
    }
    
    public void setNode(char ch, TrieNode node){
        links[ch-'a'] = node;
    }
    
    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
