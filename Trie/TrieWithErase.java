class TrieWithErase {

    private TrieNode root;

    public TrieWithErase() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.setNode(ch, new TrieNode());
            }
            node = node.getNode(ch);
            node.incrementPrefix();
        }
        node.incrementEnd();
        node.setEnd(true);
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.getNode(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public int getEndsWithCount(String word) {
        TrieNode node = searchPrefix(word);
        return (node != null && node.isEnd()) ? node.getEnd() : 0;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public int getStartsWithCount(String word) {
        TrieNode node = searchPrefix(word);
        return (node != null) ? node.getPrefix() : 0;
    }

    // Assuming erase will be called only if the word exists
    public void eraseWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.getNode(ch);
                node.decrementPrefix();
            }
        }
        node.decrementEnd();
        if (node.getEnd() == 0) {
            node.setEnd(false);
        }
    }

}

class TrieNode {
    private final TrieNode[] links;
    private boolean isEnd;
    private int end = 0;
    private int prefix = 0;
    private static final int count = 26;

    public TrieNode() {
        links = new TrieNode[count];
    }

    public TrieNode getNode(char ch) {
        return links[ch - 'a'];
    }

    public void setNode(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void setEnd(boolean value) {
        isEnd = value;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void incrementEnd() {
        end++;
    }

    public int getEnd() {
        return end;
    }

    public void incrementPrefix() {
        prefix++;
    }

    public int getPrefix() {
        return prefix;
    }

    public void decrementPrefix() {
        prefix--;
    }

    public void decrementEnd() {
        end--;
    }
}
